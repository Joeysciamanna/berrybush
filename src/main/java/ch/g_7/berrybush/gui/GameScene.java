package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.BaseScene;
import ch.g_7.berrybush.common.FancyAnimationTimer;
import ch.g_7.berrybush.common.Navigator;
import javafx.animation.AnimationTimer;
import ch.g_7.berrybush.common.KeyInputManager;
import ch.g_7.berrybush.game.BerryBushWorld;

public class GameScene extends BaseScene {

    private AnimationTimer gameLoop;
    private KeyInputManager keyEventHandler;

    public GameScene(Navigator navigator) {
        super(navigator);
        keyEventHandler = new KeyInputManager();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);
    }

    @Override
    public void onOpen() {
        BerryBushWorld marioWorld = new BerryBushWorld(keyEventHandler, navigator, ()->gameLoop.stop());
        marioWorld.load();
        gameLoop = new FancyAnimationTimer() {
            @Override
            protected void handle(double deltaInSec) {
                marioWorld.update(deltaInSec);
                marioWorld.render(getGraphicsContext());
            }
        };
        gameLoop.start();
    }

}
