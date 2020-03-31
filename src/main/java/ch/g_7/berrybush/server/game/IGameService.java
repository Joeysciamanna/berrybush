package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.server.IService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IGameService extends IService {

    IControllService getControllService(String player) throws RemoteException;

    List<BasicViewModel> getAllViewModels() throws RemoteException;

    List<BasicViewModel> getChangedViewModels() throws RemoteException;
}
