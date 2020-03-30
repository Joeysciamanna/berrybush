package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.math.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class Game extends Loop {

    private final String name;
    private final List<String> players;

    private final World world;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.world = new World();
    }

    public String getName() {
        return name;
    }

    public void add(String s) {
        world.add(new Player(new Vector2f(), s));
        players.add(s);
    }

    public List<String> getPlayers() {
        return players;
    }


    @Override
    protected void run(float deltaSeconds) {
        world.safeForEach((o)->o.update(deltaSeconds));
    }
}
