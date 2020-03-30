package ch.g_7.berrybush.game;


import ch.g_7.berrybush.common.KeyInputManager;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.GameWorld;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.game.obj.Tree;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.main.Resource;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.game.IGameService;
import ch.g_7.berrybush.server.sync.ISyncService;
import ch.g_7.berrybush.server.sync.RemoteDataSender;
import ch.g_7.berrybush.server.sync.RemoteDataSyncronizer;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class BerryBushWorld extends GameWorld {

    private final KeyInputManager keyInputManager;
    private KeyController keyController;
    private final Navigator navigator;
    private final String game;

    private final IGameService gameService;
    private final ISyncService syncService;

    private final RemoteDataSender remoteDataSender;
    private final RemoteDataSyncronizer remoteDataSyncronizer;

    public BerryBushWorld(KeyInputManager keyInputManager, Navigator navigator, Runnable stopper, String game) {
        super(stopper);
        this.keyInputManager = keyInputManager;
        this.navigator = navigator;
        this.game = game;
        this.gameService = RemoteUtil.getService(ServiceType.GAME);
        this.syncService = RemoteUtil.getService(ServiceType.SYNC);
        this.remoteDataSender = new RemoteDataSender(syncService);
        this.remoteDataSyncronizer = new RemoteDataSyncronizer(syncService);

    }

    public void load() {
        Player player = new LocalPlayer(0,0, camera);
        keyController = new KeyController(player);
        keyInputManager.add(keyController);
        remoteDataSender.add(player);
        add(player);


        for (int i = 0; i < 30; i++) {
            add(new Tree(Util.random(-Const.SCREEN_WIDTH, Const.SCREEN_WIDTH), Util.random(-Const.SCREEN_HEIGHT, Const.SCREEN_HEIGHT)));
        }

        remoteDataSender.start();
        remoteDataSyncronizer.start();
    }


    @Override
    protected void stop() {
        remoteDataSender.stop();
        remoteDataSyncronizer.stop();
        super.stop();
    }

    private void scanForRemotePlayers(){
        List<String> remotePlayers = RemoteUtil.invoke(()->gameService.getVillans(game, Const.getUserName()));
        List<Player> players = getGameObjectsOfType(Player.class);
        for (String remotePlayer : remotePlayers) {
            if(players.stream().noneMatch((p)->p.getName().equals(remotePlayer))){
                addRemotePlayer(remotePlayer);
            }
        }
    }

    private void addRemotePlayer(String name) {
        Player player = new Player(0, 0, name);
        remoteDataSyncronizer.add(player, RemoteUtil.invoke(()->syncService.getIdOf(Player::getName, name)));
        add(player);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.drawImage(Resource.GAME_BACKGROUND, 0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        super.render(gc);
    }

    @Override
    public void update(double deltaSeconds) {
        scanForRemotePlayers();
        keyController.update(deltaSeconds);
        super.update(deltaSeconds);
    }
}
