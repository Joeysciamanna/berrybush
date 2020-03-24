package ch.g_7.berrybush.main;

public class Const {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    public static final float MOVEMENT_SPEED = 100;



    private static String USER_NAME;


    public static String getUserName() {
        return USER_NAME;
    }

    public static void setUserName(String userName) {
        USER_NAME = userName;
    }
}