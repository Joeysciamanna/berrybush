package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.main.Resource;
import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.sync.ISynchronizable;

import java.io.Serializable;

public class Player extends GameObject implements ISynchronizable<Player.PlayerData> {

    private final String name;


    public Player(Vector2f position, String name) {
        super(position, Resource.PLAYER);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void applyRemoteData(PlayerData playerData) {
        getTransform().setPosition(playerData.position);
    }

    @Override
    public PlayerData getRemoteData() {
        return new PlayerData(getTransform().getPosition());
    }


    protected static class PlayerData implements Serializable {

        private Vector2f position;

        public PlayerData(Vector2f position) {
            this.position = position;
        }
    }

}
