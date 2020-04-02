package ch.g_7.berrybush.game.obj;


import ch.g_7.berrybush.framework.IEntity;
import ch.g_7.berrybush.framework.IViewModel;
import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.view_model.BasicViewModel;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.game.view_model.ImagedViewModel;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.math.Vector2f;


public abstract class GameObject<T extends IViewModel> implements IEntity {

    private T viewModel;
    private final int id;

    public GameObject(Vector2f position, T viewModel, int id) {
        this.viewModel = viewModel;
        this.viewModel.getTransform().setPosition(position);
        this.id = id;
    }

    @Override
    public void update(double deltaSeconds) { }


    @Override
    public Transform getTransform() {
        return viewModel.getTransform();
    }

    @Override
    public T getViewModel() {
        return viewModel;
    }

    @Override
    public int getId() {
        return id;
    }

    protected Vector2f getPosition(){
        return viewModel.getTransform().getPosition();
    }

    protected float getX(){
        return viewModel.getTransform().getPosition().x;
    }

    protected float getY(){
        return viewModel.getTransform().getPosition().y;
    }


}
