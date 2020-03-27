package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.game.obj.create.GameObjectType;
import ch.g_7.berrybush.math.Transform;


public class GameObjectData {

    protected final int id;
    protected final GameObjectType type;
    protected final Transform transform;

    public GameObjectData(int id, GameObjectType type, Transform transform) {
        this.id = id;
        this.type = type;
        this.transform = transform;
    }

    public GameObjectType getType() {
        return type;
    }

    public Transform getTransform() {
        return transform;
    }

    public int getId() {
        return id;
    }
}
