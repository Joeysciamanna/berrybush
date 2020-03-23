package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.BaseScene;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.main.Resource;
import javafx.scene.Group;

public class GameOverScene extends BaseScene {

    public GameOverScene(Navigator navigator) {
        super(navigator);
        setOnKeyTyped((e)-> {
            if(e.getCharacter().equals(" ")) {
                navigator.goTo(SceneType.START);
            }
        });
    }

    @Override
    public void onOpen() {
        getGraphicsContext().drawImage(Resource.GAME_OVER_BACKGROUND, 0, 0);
    }
}