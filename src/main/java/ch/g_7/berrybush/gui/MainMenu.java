package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class MainMenu extends FXMLScene<MainMenuController> {

    public MainMenu(Navigator navigator) {
        super(Resource.MAIN_MENU, navigator);
        setOnKeyTyped((e)-> {
            if(e.getCharacter().equals(" ")) {
                navigator.goTo(SceneType.GAME);
            }
        });
    }

}
