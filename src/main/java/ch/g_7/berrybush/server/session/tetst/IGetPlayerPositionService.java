package ch.g_7.berrybush.server.session.tetst;

import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;

public interface IGetPlayerPositionService extends IService {

    Vector2f getPositionOfPlayer(String playerName) throws RemoteException;

}
