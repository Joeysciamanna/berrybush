package ch.g_7.berrybush.server.session;

import ch.g_7.berrybush.server.game.GameService;

import java.io.Serializable;

public class Session implements Serializable {

    private final String name;
    private final int maxPlayers;
    private int players;
    private boolean open;
    private final String host;
    private String pw;

    private GameService gameService;


    public Session(String name, int maxPlayers, String host) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.open = true;
        this.host = host;
    }

    private Session(String name, int maxPlayers, int players, boolean open, String host) {
        this(name, maxPlayers, host);
        this.open = open;
        this.players = players;
    }

    public Session(String name, int maxPlayers, String host, String pw) {
        this(name, maxPlayers, host);
        this.open = false;
        this.pw = pw;
    }

    public void addPlayer(){
        players++;
    }

    public boolean hasSpace(){
        return players < maxPlayers;
    }

    public boolean pwEquals(String pw){
        return this.pw.equals(pw);
    }

    public Session getCleared(){
        return new Session(name, maxPlayers, players, open, host);
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getPlayers() {
        return players;
    }

    public boolean isOpen() {
        return open;
    }

    public String getHost() {
        return host;
    }

    public GameService getGameService() {
        return gameService;
    }

    protected void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
