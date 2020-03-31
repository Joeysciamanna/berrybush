package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.framework.Renderable;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;

import java.io.Serializable;

public abstract class BasicViewModel implements Renderable, Serializable {

    private final int id;
    private Transform transform;

    public BasicViewModel(Vector2f position, Vector2f scale, int id) {
        this.transform = new Transform();
        this.transform.setPosition(position);
        this.transform.setScale(scale);
        this.id = id;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    public int getId() {
        return id;
    }
}
