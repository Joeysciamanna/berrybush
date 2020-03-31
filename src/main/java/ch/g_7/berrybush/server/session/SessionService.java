package ch.g_7.berrybush.server.session;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.server.BerryBushServer;
import ch.g_7.berrybush.server.Service;
import ch.g_7.berrybush.server.ServiceType;
import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.game.IGameService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class SessionService extends Service implements ISessionService {

    private final List<Session> sessions;

    public SessionService(String name) throws RemoteException {
        super(name);
        this.sessions = new ArrayList<>();
    }

    @Override
    public IGameService create(Session session) {
        if(exists(session.getName()))
            return null;
        sessions.add(session);
        GameService service = BerryBushServer.register(GameService::new, "game/" + session.getName());
        session.setGameService(service);
        service.addPlayer(session.getHost());
        session.addPlayer();
        return service;
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
    public IGameService join(String sessionName, String userName) {
        Optional<Session> s = get(sessionName);
        if(s.isPresent()){
            Session session = s.get();
            if(session.isOpen() && session.hasSpace()) {
                GameService service = session.getGameService();
                service.addPlayer(userName);
                session.addPlayer();
                return service;
            }
        }
        return null;
    }

    @Override
    public IGameService join(String sessionName, String userName, String pw) {
        Optional<Session> s = get(sessionName);
        if(s.isPresent()){
            Session session = s.get();
            if((!session.isOpen()) && session.hasSpace() && session.pwEquals(pw)){
                GameService service = session.getGameService();
                service.addPlayer(userName);
                session.addPlayer();
                return service;
            }
        }
        return null;
    }

    @Override
    public List<Session> getAll() {
        return sessions.stream().map(Session::getCleared).collect(Collectors.toList());
    }

    private Optional<Session> get(String sessionName){
        return sessions.stream().filter((s)->s.getName().equalsIgnoreCase(sessionName)).findFirst();
    }

    @Override
    public boolean exists(String sessionName){
        return get(sessionName).isPresent();
    }
}

