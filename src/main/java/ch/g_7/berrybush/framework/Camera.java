package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;

import java.io.Serializable;

public class Camera implements Serializable {

    private Vector2f position;
    private float rotation;

    public Camera() {
        this.position = new Vector2f();
    }

    public void set(Camera camera){
        this.position = camera.position;
        this.rotation = camera.rotation;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
