package ch.g_7.berrybush.server.name;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.server.Service;
import ch.g_7.util.logging.StaticLogger;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class NameService extends Service implements INameService {

    private final List<String> playerNames;

    public NameService(String name) throws RemoteException {
        super(name);
        this.playerNames = new ArrayList<>();
    }

    @Override
    public synchronized boolean register(String name) {
        if(playerNames.contains(name)) return false;
        StaticLogger.debug("New Player [" + name + "]");
        playerNames.add(name);
        return true;
    }

    @Override
    public boolean exists(String name) {
        return playerNames.contains(name);
    }

    @Override
    public void free(String name) throws RemoteException {
        playerNames.remove(name);
    }

    @Override
    public String randomName() {
        String name = "Player_";
        int number = Util.random(1, 500000);
        while (exists(name + number)){
            number = Util.random(1, 500000);
        }
        return name + number;
    }
}
