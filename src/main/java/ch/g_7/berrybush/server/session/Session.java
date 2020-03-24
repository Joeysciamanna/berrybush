package ch.g_7.berrybush.server.session;

public class Session {

    private String name;
    private int maxPlayers;
    private int players;
    private boolean open;
    private String host;
    private String pw;

    public Session(String name, int maxPlayers, String host) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.open = true;
        this.host = host;
    }

    private Session(String name, int maxPlayers, int players, boolean open, String host) {
        this(name, maxPlayers, host);
        this.open = false;
        this.pw = pw;
    }

    public Session(String name, int maxPlayers, String host, String pw) {
        this(name, maxPlayers, host);
        this.open = false;
        this.pw = pw;
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

    public String getSize() {
        return players+"/"+maxPlayers;
    }

    public String getAccess() {
        return open ? "public" : "private";
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


}
