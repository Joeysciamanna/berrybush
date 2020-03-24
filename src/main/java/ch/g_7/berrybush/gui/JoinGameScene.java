package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class JoinGameScene extends FXMLScene<MainMenuController> {

    public JoinGameScene(Navigator navigator) {
        super(Resource.JOIN_GAME_FXML, navigator);
    }

}
