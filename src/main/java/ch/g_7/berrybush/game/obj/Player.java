package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.framework.GameObjectData;
import ch.g_7.berrybush.main.Resource;

public class Player extends GameObject<GameObjectData> {

    private final String name;


    public Player(float x, float y, String name) {
        super(x, y, Resource.PLAYER);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public GameObjectData getRemoteData() {
        return getGameObjectData();
    }

}
