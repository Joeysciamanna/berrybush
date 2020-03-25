package ch.g_7.berrybush.server.player;

import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;

import java.io.Serializable;

public class PlayerData implements Serializable {

    private String name;
    private Transform transform;

    public PlayerData(String name, Transform transform) {
        this.name = name;
        this.transform = transform;
    }

    public String getName() {
        return name;
    }

    public Transform getTransform() {
        return transform;
    }
}
