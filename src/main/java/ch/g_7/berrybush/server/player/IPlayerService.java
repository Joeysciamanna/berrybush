package ch.g_7.berrybush.server.player;

import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;

public interface IPlayerService extends IService {

    PlayerData getPlayerData(String playerName) throws RemoteException;

    void setPlayerData(PlayerData playerData) throws RemoteException;
}
