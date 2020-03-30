package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.math.Vector2f;


public class Player extends GameObject {

    private final String name;


    public Player(Vector2f position, String name) {
        super(position, ImageType.PLAYER);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
