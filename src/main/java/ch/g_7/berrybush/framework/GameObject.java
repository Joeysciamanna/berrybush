package ch.g_7.berrybush.framework;


import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.framework.render.Renderable;
import ch.g_7.berrybush.game.obj.create.GameObjectType;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.sync.ISynchronizable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class GameObject implements Updatable, Renderable, Localizable {

    private final GameObjectType type;
    private final int id;
    private Transform transform;
    private Image image;
    private boolean visible;

    public GameObject(GameObjectType type, int id, Vector2f position, Image image) {
        this(type,  id, position, (float) image.getWidth(), (float) image.getHeight());
        this.image = image;
        this.visible = true;
    }

    public GameObject(GameObjectType type, int id, Vector2f position, float width, float height) {
        this.type = type;
        this.id = id;
        this.transform = new Transform(position, new Vector2f(width, height));
    }

    @Override
    public final void draw(GraphicsContext gc) {
        if(visible){
            gc.drawImage(image, 0,0);
        }
    }

    @Override
    public void update(double deltaSeconds) { }

    protected GameObjectData getData(){
        return new GameObjectData(id, type, transform);
    }

    protected void setImage(Image image) {
        this.image = image;
        this.transform.setScale(new Vector2f((float) image.getWidth(), (float) image.getHeight()));
    }

    public Image getImage() {
        return image;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }
}
