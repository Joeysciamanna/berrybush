package ch.g_7.berrybush.server;

import jdk.internal.agent.resources.agent;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class RemoteUtil {

    private static final String PATH = "rmi://localhost:1109/";

    private static final Map<ServiceType, IService> SERVICES = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends IService> T getService(ServiceType type){
        if(!SERVICES.containsKey(type)){
            registerService(type);
        }
        return (T) SERVICES.get(type);
    }

    private static void registerService(ServiceType type) {
        try {
            IService service = (IService) Naming.lookup(PATH + type.getName());
            SERVICES.put(type, service);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Serializable> T invoke(RemoteFunction<T> function){
        try {
            return function.invoke();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public static void invokeVoid(VoidRemoteFunction function){
        try {
            function.invoke();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    public interface RemoteFunction<T extends Serializable>{
        T invoke() throws RemoteException;
    }

    @FunctionalInterface
    public interface VoidRemoteFunction{
        void invoke() throws RemoteException;
    }
}
