package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;

public class GameOverScene extends FXMLScene<GameOverController> {

    public GameOverScene(Navigator navigator) {
        super(Resource.MAIN_MENU, navigator);
        setOnKeyTyped((e)-> {
            if(e.getCharacter().equals(" ")) {
                navigator.goTo(SceneType.MAIN_MENU);
            }
        });
    }

}
