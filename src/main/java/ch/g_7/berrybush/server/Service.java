package ch.g_7.berrybush.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public abstract class Service extends UnicastRemoteObject implements IService{

    private static final long serialVersionUID = 1L;

    private final String name;

    public Service(String name) throws RemoteException {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
