package ch.g_7.berrybush.server.sync;

import ch.g_7.berrybush.server.IService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.function.Function;

public interface ISyncService extends IService {

    Serializable getData(int id) throws RemoteException;

    void setData(int id, Serializable data)  throws RemoteException;

    int genId() throws RemoteException;

}
