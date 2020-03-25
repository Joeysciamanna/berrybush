package ch.g_7.berrybush.server;


import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.name.NameService;
import ch.g_7.berrybush.server.player.PlayerService;
import ch.g_7.berrybush.server.session.SessionService;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class BerryBushServer {


    private static Map<ServiceType, Service> services;
    private static Registry registry;

    public static void main(String[] args) {
        try {
            registerServices();
            setupServer();
            System.err.println("---SERVER READY---\n");
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void registerServices() throws RemoteException {
        services = new HashMap<>();
        services.put(ServiceType.NAME, new NameService());
        services.put(ServiceType.SESSION, new SessionService());
        services.put(ServiceType.GAME, new GameService());
        services.put(ServiceType.PLAYER, new PlayerService());
    }

    private static void setupServer() throws RemoteException, AlreadyBoundException {
        registry = LocateRegistry.createRegistry(1109);
        for (Map.Entry<ServiceType, Service> entry : services.entrySet()) {
            registry.bind(entry.getKey().getName(), entry.getValue());
        }
    }


    @SuppressWarnings("unchecked")
    public static <T extends Service> T getService(ServiceType service){
        return (T) services.get(service);
    }

}
