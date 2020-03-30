package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.server.IService;
import ch.g_7.berrybush.server.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GameService extends Service implements IGameService {

    private final List<Game> games;

    public GameService() throws RemoteException {
        this.games = new ArrayList<>();
    }

    @Override
    public List<String> getVillans(String gameName, String userName) {
        boolean found = false;
        List<String> villans = new ArrayList<>();
        for (String player : getGame(gameName).getPlayers()) {
            if(!player.equals(userName)){
                villans.add(player);
            }else{
                found = true;
            }
        }
        if(!found){
            throw new RuntimeException("Player ["+userName+"] has no access to game ["+gameName+"]");
        }
        return villans;
    }

    public void addPlayer(String gameName, String player) {
        getGame(gameName).add(player);
    }

    public void createGame(String gameName, String player) {
        Game game = new Game(gameName);
        game.add(player);
        games.add(game);
        game.start();
    }

    private Game getGame(String gameName){
        return games.stream().filter((g)->g.getName().equals(gameName)).findFirst().get();
    }
}
