package ch.g_7.berrybush.server.session;

import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;
import java.util.List;

public interface ISessionService extends IService {

    String randomName() throws RemoteException;

    boolean exists(String name) throws RemoteException;

    boolean create(Session session) throws RemoteException;

    boolean join(String sessionName) throws RemoteException;

    boolean join(String sessionName, String pw) throws RemoteException;

    List<Session> getAll() throws RemoteException;
}
