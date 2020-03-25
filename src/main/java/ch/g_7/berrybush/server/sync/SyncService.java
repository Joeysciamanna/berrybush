package ch.g_7.berrybush.server.sync;

import ch.g_7.berrybush.server.Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class SyncService extends Service implements ISyncService {

    private int idCounter = 1;
    private final Map<Integer, Serializable> datas;


    public SyncService() throws RemoteException {
        datas = new HashMap<>();
    }

    @Override
    public Serializable getData(int id) throws RemoteException {
        return datas.get(id);
    }

    @Override
    public void setData(int id, Serializable data) throws RemoteException {
        datas.put(id, data);
    }

    @Override
    public int genId() throws RemoteException {
        return idCounter++;
    }
}
