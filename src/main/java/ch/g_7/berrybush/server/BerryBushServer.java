package ch.g_7.berrybush.server;


import ch.g_7.berrybush.server.name.NameService;
import ch.g_7.berrybush.server.session.SessionService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BerryBushServer {

    private static Registry registry;

    public static void main(String[] args) {
        try {

            registry = LocateRegistry.createRegistry(1109);

            registry.rebind(ServiceType.NAME.getName(), new NameService());
            registry.rebind(ServiceType.SESSION.getName(), new SessionService());

            System.err.println("---SERVER READY---\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
