package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;

import java.io.Serializable;

public class GameObjectData implements Serializable {

    private Transform transform;

    public GameObjectData(Transform transform) {
        this.transform = transform;
    }

    public Transform getTransform() {
        return transform;
    }
}
