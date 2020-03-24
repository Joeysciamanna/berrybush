package ch.g_7.berrybush.main;

import ch.g_7.berrybush.gui.*;
import javafx.application.Application;
import javafx.stage.Stage;
import ch.g_7.berrybush.common.Navigator;

public class BerryBush extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BerryBush Online Battle Royal");

        Navigator navigator = new Navigator(stage);
        navigator.registerScene(SceneType.MAIN_MENU, new MainMenuScene(navigator));
        navigator.registerScene(SceneType.NEW_GAME, new NewGameScene(navigator));
        navigator.registerScene(SceneType.JOIN_GAME, new JoinGameScene(navigator));

        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAME_OVER, new GameOverScene(navigator));
        navigator.registerScene(SceneType.GAME_WON, new GameWonScene(navigator));

        navigator.goTo(SceneType.MAIN_MENU);

        stage.setResizable(false);
        stage.show();
    }
}
