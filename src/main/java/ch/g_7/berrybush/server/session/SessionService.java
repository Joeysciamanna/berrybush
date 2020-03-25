package ch.g_7.berrybush.server.session;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.server.BerryBushServer;
import ch.g_7.berrybush.server.Service;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.game.GameService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class SessionService extends Service implements ISessionService {

    private final List<Session> sessions;

    public SessionService() throws RemoteException {
        this.sessions = new ArrayList<>();
    }

    @Override
    public boolean create(Session session) {
        if(exists(session.getName()))
            return false;
        sessions.add(session);
        GameService service = BerryBushServer.getService(ServiceType.GAME);
        service.createGame(session.getName(), session.getHost());
        session.addPlayer();
        return true;
    }

    @Override
    public String randomName() {
        String name = "Game_";
        int number = Util.random(1, 500000);
        while (exists(name + number)){
            number = Util.random(1, 500000);
        }
        return name + number;
    }

    @Override
    public boolean join(String sessionName, String userName) {
        Optional<Session> s = get(sessionName);
        if(s.isPresent()){
            Session session = s.get();
            if(session.isOpen() && session.hasSpace()) {
                GameService service = BerryBushServer.getService(ServiceType.GAME);
                service.addPlayer(sessionName, userName);
                session.addPlayer();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean join(String sessionName, String userName, String pw) {
        Optional<Session> s = get(sessionName);
        if(s.isPresent()){
            Session session = s.get();
            if((!session.isOpen()) && session.hasSpace() && session.pwEquals(pw)){
                GameService service = BerryBushServer.getService(ServiceType.GAME);
                service.addPlayer(sessionName, userName);
                session.addPlayer();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Session> getAll() {
        return sessions.stream().map(Session::getCleared).collect(Collectors.toList());
    }

    private Optional<Session> get(String sessionName){
        return sessions.stream().filter((s)->s.getName().equals(sessionName)).findFirst();
    }

    @Override
    public boolean exists(String sessionName){
        return get(sessionName).isPresent();
    }
}

