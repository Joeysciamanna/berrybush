package ch.g_7.berrybush.server.sync;


import ch.g_7.berrybush.server.RemoteUtil;

import java.util.Map;

public class RemoteDataSender extends RemoteDataHandler {


    public RemoteDataSender(ISyncService syncService) {
        super(syncService);
    }

    @Override
    public void update(double deltaSeconds) {
        for (Map.Entry<Integer, ISynchronizable<?>> entry : syncronizables.entrySet()) {
            RemoteUtil.invokeVoid(()->syncService.setData(entry.getKey(), entry.getValue().getRemoteData()));
        }
    }

    protected void add(ISynchronizable<?> syncronizable){
        syncronizables.put(RemoteUtil.invoke(()->syncService.genId()), syncronizable);
    }



}
