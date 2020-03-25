package ch.g_7.berrybush.server.sync;

import ch.g_7.berrybush.framework.Updatable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RemoteDataHandler implements Updatable {

    protected final Map<Integer, ISynchronizable<?>> syncronizables;
    protected final ISyncService syncService;

    public RemoteDataHandler(ISyncService syncService) {
        this.syncronizables = new HashMap<>();
        this.syncService = syncService;
    }

    public void clear(){
        syncronizables.clear();
    }


}
