package ch.g_7.berrybush.server.session.tetst;

import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.Service;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class GetPlayerPositionServicer extends Service implements IGetPlayerPositionService {

    private Map<String, Vector2f> vector2fMap;

    public GetPlayerPositionServicer() throws RemoteException {
        vector2fMap = new HashMap<>();
        vector2fMap.put("Tom", new Vector2f(10, 10));
        vector2fMap.put("Peter", new Vector2f(14,324));
    }

    @Override
    public Vector2f getPositionOfPlayer(String playerName) {
        return vector2fMap.get(playerName);
    }
}
