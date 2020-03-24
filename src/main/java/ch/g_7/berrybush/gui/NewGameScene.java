package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class NewGameScene extends FXMLScene<NewGameController> {

    public NewGameScene(Navigator navigator) {
        super(Resource.NEW_GAME_FXML, navigator);
    }

}
