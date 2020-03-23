package ch.g_7.berrybush.framework.render;

import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;

public class Camera {

    private Vector2f position;
    private float rotation;

    public Camera() {
        this.position = new Vector2f();
    }

    public float getRotation() {
        return rotation;
    }

    public Vector2f getPosition() {
        return position;
    }
}
