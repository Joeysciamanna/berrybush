package ch.g_7.berrybush.server.player;

import ch.g_7.berrybush.server.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerService extends Service implements IPlayerService {

    private List<PlayerData> playerDatas;

    public PlayerService() throws RemoteException {
        this.playerDatas = new ArrayList<>();
    }

    @Override
    public PlayerData getPlayerData(String playerName) throws RemoteException {
        return get(playerName).orElse(null);
    }

    @Override
    public void setPlayerData(PlayerData playerData) throws RemoteException {
        if(get(playerData.getName()).isPresent()){
            playerDatas.removeIf((p)->p.getName().equals(playerData.getName()));
        }
        playerDatas.add(playerData);
    }

    private Optional<PlayerData> get(String name){
        return playerDatas.stream().filter((p)->p.getName().equals(name)).findFirst();
    }
}
