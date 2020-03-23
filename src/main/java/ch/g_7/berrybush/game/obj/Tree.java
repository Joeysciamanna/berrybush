package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.main.Resource;
import javafx.scene.image.Image;

public class Tree extends GameObject {

    public Tree(float x, float y) {
        super(x, y, Util.randomFormList(Resource.TREE_1, Resource.TREE_2));
    }
}
