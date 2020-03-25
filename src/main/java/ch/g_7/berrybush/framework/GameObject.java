package ch.g_7.berrybush.framework;


import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.framework.render.Renderable;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;
import ch.g_7.berrybush.server.sync.ISynchronizable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class GameObject<T extends GameObjectData> implements Updatable, Renderable, Localizable, ISynchronizable<T> {

    private Image image;
    private boolean visible;
    private Transform transform;

    public GameObject(float x, float y, Image image) {
        this(x,y, (float) image.getWidth(), (float) image.getHeight());
        this.image = image;
        this.visible = true;
    }

    public GameObject(float x, float y, float width, float height) {
        this.transform = new Transform(new Vector2f(x, y), new Vector2f(width, height));
    }

    @Override
    public final void draw(GraphicsContext gc) {
        if(visible){
            gc.drawImage(image, 0,0);
        }
    }

    @Override
    public void update(double deltaSeconds) { }

    @Override
    public void applyRemoteData(T t) {
        this.transform = t.getTransform();
    }

    public GameObjectData getGameObjectData(){
        return new GameObjectData(transform);
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
