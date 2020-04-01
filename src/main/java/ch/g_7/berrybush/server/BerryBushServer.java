package ch.g_7.berrybush.server;


import ch.g_7.berrybush.common.CheckedFunction;
import ch.g_7.berrybush.main.PropertyKey;
import ch.g_7.berrybush.server.name.NameService;
import ch.g_7.berrybush.server.session.SessionService;
import ch.g_7.util.helper.AppInitializer;
import ch.g_7.util.io.LocalFileLoader;
import ch.g_7.util.logging.StaticLogger;
import ch.g_7.util.properties.IProperties;
import ch.g_7.util.properties.PropertyParser;
import ch.g_7.util.properties.PropertyProducer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BerryBushServer {

    private static final IProperties PROPERTIES = PropertyProducer.getDefaultProperties();
    private static Registry registry;

    public static void main(String[] args) {
        AppInitializer appInitializer = new AppInitializer(true, "BerryBushServer", new LocalFileLoader() {} );
        appInitializer.runDefaults("server_properties.prop");

        try {
            int port = PROPERTIES.get(PropertyKey.PORT);
            registry = LocateRegistry.createRegistry(port);
            StaticLogger.info("Server listening on port: " + port);

            registerServices();

            StaticLogger.debug("Server Services registered");
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
            return service;
        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }

}
