package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.BaseScene;
import ch.g_7.berrybush.common.FXMLScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;
import javafx.scene.Group;

public class WelcomeScene extends FXMLScene<WelcomeController> {

    public WelcomeScene(Navigator navigator) {
        super(navigator, Resource.);
        setOnKeyTyped((e)-> {
            if(e.getCharacter().equals(" ")) {
                navigator.goTo(SceneType.GAME);
            }
        });
    }

    @Override
    public void onOpen() {
        getGraphicsContext().drawImage(Resource.START_BACKGROUND, 0, 0);
    }
}
