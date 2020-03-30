package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.framework.render.Renderable;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;
import javafx.scene.canvas.GraphicsContext;

public abstract class BasicViewModel implements Renderable {

    private Transform transform;

    public BasicViewModel(Vector2f position, Vector2f scale) {
        this.transform = new Transform();
        this.transform.setPosition(position);
        this.transform.setScale(scale);
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

}
