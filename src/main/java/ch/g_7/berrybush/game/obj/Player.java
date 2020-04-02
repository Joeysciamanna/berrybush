package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.game.item.ITool;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.math.Vector2f;

import java.awt.*;


public class Player extends GameObject implements Damagable {

    private final String name;
    private int health;



    public Player(Vector2f position, String name, int id) {
        super(position, new ImagedViewModel(ImageType.PLAYER, id), id);
        this.name = name;
        this.health = 100;
    }

    public String getName() {
        return name;
    }


    @Override
    public void damage(IBeeing beeing, ITool tool) {

    }
}
