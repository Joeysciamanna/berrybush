package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.framework.GameObjectData;
import ch.g_7.berrybush.main.Resource;

import java.io.Serializable;

public class Tree extends GameObject<GameObjectData> {

    public Tree(float x, float y) {
        super(x, y, Util.randomFormList(Resource.TREE_1, Resource.TREE_2));
    }


    @Override
    public GameObjectData getRemoteData() {
        return getGameObjectData();
    }
}
