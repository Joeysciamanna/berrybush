package ch.g_7.berrybush.framework;


import ch.g_7.berrybush.framework.render.Renderable;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject implements Updatable, Renderable, Localizable {

    private Image image;
    private boolean visible;
    private final Transform transform;

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

    public Image getImage() {
        return image;
    }

    protected void setImage(Image image) {
        this.image = image;
        this.transform.setScale(new Vector2f((float) image.getWidth(), (float) image.getHeight()));
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
}
