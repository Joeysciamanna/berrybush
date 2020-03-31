package ch.g_7.berrybush.server.session;

import ch.g_7.berrybush.server.IService;
import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.game.IGameService;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public interface ISessionService extends IService {

    String randomName() throws RemoteException;

    boolean exists(String name) throws RemoteException;

    IGameService create(Session session) throws RemoteException;

    IGameService join(String sessionName, String userName) throws RemoteException;

    IGameService join(String sessionName, String userName, String pw) throws RemoteException;

    List<Session> getAll() throws RemoteException;


}
