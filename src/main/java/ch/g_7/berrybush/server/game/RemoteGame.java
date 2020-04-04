package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.common.Loop;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.IEntity;
import ch.g_7.berrybush.framework.IViewModel;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.obj.GameObject;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.game.obj.Stone;
import ch.g_7.berrybush.game.obj.Tree;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.math.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RemoteGame extends Loop {

    private final String name;

    private final World world;
    private final List<Updatable> updatables;
    private final CollisionHandler collisionHandler;

    public RemoteGame(String name) {
        this.name = name;
        this.world = new World();
        this.updatables = new ArrayList<>();
        this.collisionHandler = new CollisionHandler(world);
        loadEntities();
    }

    private void loadEntities() {
        for (int i = 0; i < 30; i++) {
            Vector2f pos = Util.randomPosition(-Const.SCREEN_WIDTH, Const.SCREEN_WIDTH, -Const.SCREEN_HEIGHT, Const.SCREEN_HEIGHT);
            add(new Stone(pos, new Vector2f(30,30), world, nextId()));
        }

    }

    public String getName() {
        return name;
    }

    public void addPlayer(String playerName) {
       add(new Player(new Vector2f(), playerName, nextId()));
    }

    public Optional<Player> getPlayer(String playerName){
        return world.getEntityOfTypeWhere(Player.class, (p)->p.getName().equalsIgnoreCase(playerName));
    }

    @Override
    protected void run(double deltaSeconds) {
        world.safeForEach((o)->o.update(deltaSeconds));
        updatables.forEach((u)->u.update(deltaSeconds));
        collisionHandler.update(deltaSeconds);
        timer.sleep(5);
    }

    private void add(GameObject gameObject){
        world.add(gameObject);
    }


    public void addUpdatable(Updatable updatable){
        updatables.add(updatable);
    }

    public List<IViewModel> getAllViewModels(){
        return world.getEntities().stream().map(IEntity::getViewModel).collect(Collectors.toList());
    }

    private int idCounter = 0;
    private int nextId(){
        return idCounter++;
    }
}
