package ch.g_7.berrybush.game;


import ch.g_7.berrybush.common.KeyInputManager;
import ch.g_7.berrybush.common.Loop;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.Camera;
import ch.g_7.berrybush.framework.Renderer;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.game.obj.Tree;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.main.Resource;

import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.game.ControllService;
import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.game.IControllService;
import ch.g_7.berrybush.server.game.IGameService;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class BerryBushWorld extends Loop {

    private List<BasicViewModel> viewModels;

    protected final Camera camera;
    private final Renderer renderer;

    protected Runnable stopper;

    private final KeyInputManager keyInputManager;
    private KeyController keyController;
    private final Navigator navigator;

    private final IGameService gameService;
    private final IControllService controllService;


    public BerryBushWorld(KeyInputManager keyInputManager, Navigator navigator, Runnable stopper, IGameService gameService) {
        this.keyInputManager = keyInputManager;
        this.navigator = navigator;
        this.stopper = stopper;

        this.camera = new Camera();
        this.renderer = new Renderer(camera);
        this.viewModels = new ArrayList<>();

        this.gameService = gameService;
        this.controllService = RemoteUtil.get(()->gameService.getControllService(Const.getUserName()));
    }

    public synchronized void start() {
        super.start();
        keyController = new KeyController(controllService);
        keyInputManager.add(keyController);
        setViewModels(RemoteUtil.get(gameService::getAllViewModels));
    }

    @Override
    protected void run(double deltaSeconds) {
        List<BasicViewModel> viewModels = RemoteUtil.get(gameService::getChangedViewModels);
        for (BasicViewModel viewModel : this.viewModels) {
            if(viewModel)
        }
        timer.sleep(1);
    }



    public synchronized void render(GraphicsContext gc){
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.drawImage(Resource.GAME_BACKGROUND, 0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        renderer.render(viewModels, gc);
    }


    public synchronized void stop() {
        stopper.run();
        super.stop();
    }

    private boolean contains(int id){
        for (BasicViewModel viewModel : viewModels) {
            if (viewModel.getId() == id){
                return true;
            }
        }
        return false;
    }

    private synchronized void  setViewModels(List<BasicViewModel> viewModels){
        this.viewModels = viewModels;
    }


}
