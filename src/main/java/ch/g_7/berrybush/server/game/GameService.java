package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.obj.GameObject;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.server.BerryBushServer;
import ch.g_7.berrybush.server.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

public class GameService extends Service implements IGameService {

    private final RemoteGame game;

    public GameService(String name) throws RemoteException {
        super(name);
        this.game = new RemoteGame(name.split("/")[1]);
        game.start();
    }


    public void addPlayer(String player) {
        game.addPlayer(player);
    }

    @Override
    public List<BasicViewModel> getAllViewModels() {
        return game.getAllViewModels();
    }

    @Override
    public List<BasicViewModel> getChangedViewModels() throws RemoteException {
        return game.getChangingViewModels();
    }

    @Override
    public IControllService getControllService(String playerName) {
        ControllService service = BerryBushServer.register(ControllService::new, "game/controll/" + playerName);
        service.setPlayer(game.getPlayer(playerName).get());
        game.addUpdatable(service);
        return service;
    }
}
