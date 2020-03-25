package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.*;
import ch.g_7.berrybush.server.session.Session;
import ch.g_7.berrybush.server.session.SessionService;
import javafx.animation.AnimationTimer;
import ch.g_7.berrybush.game.BerryBushWorld;

public class GameScene extends CanvasScene implements IDataReceiver<String> {

    private String gameName;
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
        BerryBushWorld marioWorld = new BerryBushWorld(keyEventHandler, navigator, ()->gameLoop.stop(), gameName);
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

    @Override
    public void receive(String gameName) {
        this.gameName = gameName;
    }
}
