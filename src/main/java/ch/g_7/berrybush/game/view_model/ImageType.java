package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.main.Resource;
import javafx.scene.image.Image;

public enum ImageType {
    PLAYER, TREE_1, TREE_2;


    public Image getImage() {
        switch (this){
            case PLAYER:
                return Resource.PLAYER;
            case TREE_1:
                return Resource.TREE_1;
            case TREE_2:
                return Resource.TREE_2;
        }
        throw new RuntimeException("ImageType does not have an Image");
    }
}
