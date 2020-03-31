package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;

public interface IControllService extends IService {

    void setForward(boolean doMove) throws RemoteException;

    void setBackward(boolean doMove) throws RemoteException;

    void setLeft(boolean doMove) throws RemoteException;

    void setRight(boolean doMove) throws RemoteException;

    void interact() throws RemoteException;

    void shoot() throws RemoteException;

}
