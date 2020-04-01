package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.game.view_model.ImageType;
import ch.g_7.berrybush.main.Resource;
import ch.g_7.berrybush.math.Vector2f;

public class Tree extends GameObject {

    public Tree(Vector2f position, int id) {
        super(position, Util.randomFormList(ImageType.TREE_1, ImageType.TREE_2), id);
        getTransform().getScale().mul(5);
    }

}
