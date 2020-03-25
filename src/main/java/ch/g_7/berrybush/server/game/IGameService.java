package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;
import java.util.List;

public interface IGameService extends IService {

    List<String> getVillans(String game, String userName) throws RemoteException;



}
