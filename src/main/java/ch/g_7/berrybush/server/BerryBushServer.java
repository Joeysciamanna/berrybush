package ch.g_7.berrybush.server;


import ch.g_7.berrybush.common.CheckedFunction;
import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.name.NameService;
import ch.g_7.berrybush.server.session.SessionService;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BerryBushServer {


    private static Map<String, Service> services;
    private static Registry registry;

    public static void main(String[] args) {
        try {
            services = new HashMap<>();
            registry = LocateRegistry.createRegistry(1109);

            registerServices();

            System.err.println("---SERVER READY---\n");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    private static void registerServices() {
        register(NameService::new, ServiceType.NAME.getName());
        register(SessionService::new, ServiceType.SESSION.getName());
    }

    public static <T extends Service> T register(CheckedFunction<String, T, RemoteException> constructor, String name){
        try {
            T service = constructor.apply(name);
            registry.bind(name, service);
            services.put(name, service);
            return service;
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public static <T extends Service> T getService(ServiceType service){
        return (T) services.get(service.getName());
    }

}
