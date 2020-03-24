package ch.g_7.berrybush.server.name;

import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;

public interface INameService extends IService {

    boolean register(String name) throws RemoteException;

    boolean exists(String name) throws RemoteException;

    void free(String name) throws RemoteException;

    String randomName() throws RemoteException;

}
