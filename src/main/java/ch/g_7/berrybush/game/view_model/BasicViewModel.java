package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.framework.IViewModel;
import ch.g_7.berrybush.math.Transform;

public abstract class BasicViewModel implements IViewModel {

    private final int id;
    private Transform transform;

    public BasicViewModel(int id) {
        this.transform = new Transform();
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
