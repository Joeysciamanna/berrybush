package ch.g_7.berrybush.main;


import javafx.scene.image.Image;

import java.io.InputStream;

public class Resource {

    public static final Image START_BACKGROUND = loadImage("/start_bg.png");
    public static final Image GAME_BACKGROUND = loadImage("/grass.png");
    public static final Image GAME_OVER_BACKGROUND = loadImage("/lost_bg.png");
    public static final Image GAME_WON_BACKGROUND = loadImage("/won_bg.png");

    public static final Image PLAYER = loadImage("/player.png");
    public static final Image TREE_1 = loadImage("/tree1.png");
    public static final Image TREE_2 = loadImage("/tree2.png");



    private static Image loadImage(String path){
        InputStream stream = Resource.class.getResourceAsStream(path);
        if(stream == null){
            throw new IllegalArgumentException("Image [" + path + "] not found");
        }
        return new Image(stream);
    }
}
