package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.obj.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private List<String> players;

    public Game(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean add(String s) {
        return players.add(s);
    }

    public List<String> getPlayers() {
        return players;
    }


}
