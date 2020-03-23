package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.main.Resource;

public class Player extends GameObject {

    public Player(float x, float y) {
        super(x, y, Resource.PLAYER);
    }

}
