package ch.g_7.berrybush.server.sync;

import ch.g_7.berrybush.framework.Updatable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RemoteDataHandler implements Runnable{

    protected final Map<Integer, ISynchronizable<?>> syncronizables;
    protected final ISyncService syncService;

    private Thread thread;
    private boolean running;

    public RemoteDataHandler(ISyncService syncService) {
        this.syncronizables = new HashMap<>();
        this.syncService = syncService;
    }

    @Override
    public final void run() {
        while (running) {
            handle();
        }
    }

    protected abstract void handle();

    public void start() {
        setRunning(true);
    }

    public void stop() {
        setRunning(false);
    }

    private void setRunning(boolean running) {
        if (running && !this.running) {
            this.running = true;
            thread = new Thread(this);
            thread.start();
        } else if (!running && this.running) {
            this.running = false;
            thread = null;
        }
    }

    public void clear(){
        syncronizables.clear();
    }


}
