package ch.g_7.berrybush.game.obj;


import ch.g_7.berrybush.framework.GameObjectData;
import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.framework.render.Renderable;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class GameObject implements Updatable, Localizable {

    private BasicViewModel viewModel;

    public GameObject(Vector2f position, ImageType image) {
        this.viewModel = new ImagedViewModel(position, image);
    }

    @Override
    public void update(double deltaSeconds) { }


    @Override
    public Transform getTransform() {
        return viewModel.getTransform();
    }

}
