package ch.g_7.berrybush.gui;

import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class GameWonScene extends FXMLScene<GameWonController> {

    public GameWonScene(Navigator navigator) {
        super(Resource.MAIN_MENU_FXML, navigator);
        setOnKeyTyped((e)-> {
            if(e.getCharacter().equals(" ")) {
                navigator.goTo(SceneType.MAIN_MENU);
            }
        });
    }

}
