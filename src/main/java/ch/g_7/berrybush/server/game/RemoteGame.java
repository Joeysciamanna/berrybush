package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.common.Loop;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.obj.GameObject;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.game.obj.Tree;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.math.Vector2f;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RemoteGame extends Loop {

    private final String name;

    private final World world;
    private List<Updatable> updatables;

    private List<BasicViewModel> changingViewModels;

    public RemoteGame(String name) {
        this.name = name;
        this.world = new World();
        this.updatables = new ArrayList<>();
        this.changingViewModels = new ArrayList<>();
        load();
    }

    private void load() {
        for (int i = 0; i < 30; i++) {
            Vector2f pos = Util.randomPosition(-Const.SCREEN_WIDTH, Const.SCREEN_WIDTH, -Const.SCREEN_HEIGHT, Const.SCREEN_HEIGHT);
            addStatic(new Tree(pos, nextId()));
        }
    }

    public String getName() {
        return name;
    }

    public void addPlayer(String playerName) {
       addChanging(new Player(new Vector2f(), playerName, nextId()));
    }

    public Optional<Player> getPlayer(String playerName){
        return world.getGameObjectOfTypeWhere(Player.class, (p)->p.getName().equalsIgnoreCase(playerName));
    }

    @Override
    protected void run(double deltaSeconds) {
        world.safeForEach((o)->o.update(deltaSeconds));
        updatables.forEach((u)->u.update(deltaSeconds));
        timer.sleep(5);
    }

    private void addStatic(GameObject gameObject){
        world.add(gameObject);
    }

    private void addChanging(GameObject gameObject){
        world.add(gameObject);
        changingViewModels.add(gameObject.getViewModel());
    }

    public void addUpdatable(Updatable updatable){
        updatables.add(updatable);
    }

    public List<BasicViewModel> getAllViewModels(){
        return world.getGameObjects().stream().map(GameObject::getViewModel).collect(Collectors.toList());
    }

    public List<BasicViewModel> getChangingViewModels(){
        return changingViewModels;
    }

    private int idCounter = 0;
    private int nextId(){
        return idCounter++;
    }
}
