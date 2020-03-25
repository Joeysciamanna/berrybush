package ch.g_7.berrybush.server.sync;

import ch.g_7.berrybush.server.RemoteUtil;

import java.io.Serializable;
import java.util.Map;

public class RemoteDataSyncronizer extends RemoteDataHandler {


    public RemoteDataSyncronizer(ISyncService syncService) {
        super(syncService);
    }

    @Override
    public void update(double deltaSeconds) {
        for (Map.Entry<Integer, ISynchronizable<?>> entry : syncronizables.entrySet()) {
            Serializable data = RemoteUtil.invoke(()->syncService.getData(entry.getKey()));
            entry.getValue().applyRemoteData(cast(data));
        }
    }

    protected void add(ISynchronizable<?> syncronizable, int id){
        syncronizables.put(id, syncronizable);
    }

    private <T extends Serializable> T cast(Serializable data) {
        return (T) data;
    }



}
