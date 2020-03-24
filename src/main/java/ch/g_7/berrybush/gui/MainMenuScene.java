package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class MainMenuScene extends FXMLScene<MainMenuController> {

    public MainMenuScene(Navigator navigator) {
        super(Resource.MAIN_MENU_FXML, navigator);
    }

}
