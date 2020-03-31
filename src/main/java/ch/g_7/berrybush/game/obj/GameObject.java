package ch.g_7.berrybush.game.obj;


import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;


public abstract class GameObject implements Updatable, Localizable {

    private BasicViewModel viewModel;
    private final int id;

    public GameObject(Vector2f position, ImageType image, int id) {
        this.viewModel = new ImagedViewModel(position, image, id);
        this.id = id;
    }

    @Override
    public void update(double deltaSeconds) { }


    @Override
    public Transform getTransform() {
        return viewModel.getTransform();
    }

    public BasicViewModel getViewModel() {
        return viewModel;
    }

    public int getId() {
        return id;
    }
}
