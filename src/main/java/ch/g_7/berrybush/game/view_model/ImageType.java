package ch.g_7.berrybush.game.view_model;

import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.main.Resource;
import javafx.scene.image.Image;

import javax.security.auth.login.CredentialNotFoundException;

public enum ImageType {
    PLAYER,
    TREE_1, TREE_2,
    CHEST, CHEST_OPEN,
    STONE_CLUSTER_1, STONE_CLUSTER_2, STONE_CLUSTER_3,
    IRON_CLUSTER_1, IRON_CLUSTER_2, IRON_CLUSTER_3;


    public Image getImage() {
        switch (this){
            case PLAYER:
                return Resource.PLAYER;
            case TREE_1:
                return Resource.TREE_1;
            case TREE_2:
                return Resource.TREE_2;
            case STONE_CLUSTER_1:
                return Resource.STONE_CLUSTER_1;
            case STONE_CLUSTER_2:
                return Resource.STONE_CLUSTER_2;
            case STONE_CLUSTER_3:
                return Resource.STONE_CLUSTER_3;
            case IRON_CLUSTER_1:
                return Resource.IRON_CLUSTER_1;
            case IRON_CLUSTER_2:
                return Resource.IRON_CLUSTER_2;
            case IRON_CLUSTER_3:
                return Resource.IRON_CLUSTER_3;
        }
        throw new RuntimeException("ImageType does not have an Image");
    }
}
