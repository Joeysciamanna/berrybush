package ch.g_7.berrybush.server;

public enum ServiceType {

    NAME("name"),
    SESSION("session");

    private String name;

    ServiceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
