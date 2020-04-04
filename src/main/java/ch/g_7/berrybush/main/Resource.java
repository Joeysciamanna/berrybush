package ch.g_7.berrybush.main;


import javafx.scene.image.Image;

import java.io.InputStream;

public class Resource {

    public static final Image START_BACKGROUND = loadImage("/images/start_bg.png");
    public static final Image GAME_BACKGROUND = loadImage("/images/grass.png");
    public static final Image GAME_OVER_BACKGROUND = loadImage("/images/lost_bg.png");
    public static final Image GAME_WON_BACKGROUND = loadImage("/images/won_bg.png");

    public static final Image PLAYER = loadImage("/images/player.png");
    public static final Image TREE_1 = loadImage("/images/tree1.png");
    public static final Image TREE_2 = loadImage("/images/tree2.png");

    public static final Image STONE_CLUSTER_1 = loadImage("/images/stone_cluster/clean_1.png");
    public static final Image STONE_CLUSTER_2 = loadImage("/images/stone_cluster/clean_2.png");
    public static final Image STONE_CLUSTER_3 = loadImage("/images/stone_cluster/clean_3.png");
    public static final Image[] STONE_CLUSTERS = new Image[]{ STONE_CLUSTER_1, STONE_CLUSTER_2, STONE_CLUSTER_2 };
    public static final Image IRON_CLUSTER_1 = loadImage("/images/stone_cluster/iron_1.png");
    public static final Image IRON_CLUSTER_2 = loadImage("/images/stone_cluster/iron_2.png");
    public static final Image IRON_CLUSTER_3 = loadImage("/images/stone_cluster/iron_3.png");


    public static final String MAIN_MENU_FXML = "/fxml/main_menu.fxml";
    public static final String JOIN_GAME_FXML = "/fxml/join_game.fxml";
    public static final String NEW_GAME_FXML = "/fxml/new_game.fxml";

    private static Image loadImage(String path){
        InputStream stream = Resource.class.getResourceAsStream(path);
        if(stream == null){
            throw new IllegalArgumentException("Image [" + path + "] not found");
        }
        return new Image(stream);
    }
}
