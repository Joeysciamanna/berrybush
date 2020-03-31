package ch.g_7.berrybush.gui;


import ch.g_7.berrybush.common.*;
import ch.g_7.berrybush.server.game.GameService;
import ch.g_7.berrybush.server.game.IGameService;
import ch.g_7.berrybush.server.session.Session;
import ch.g_7.berrybush.server.session.SessionService;
import javafx.animation.AnimationTimer;
import ch.g_7.berrybush.game.BerryBushWorld;

public class GameScene extends CanvasScene implements IDataReceiver<IGameService> {

    private IGameService gameService;
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
        BerryBushWorld berryBushWorld = new BerryBushWorld(keyEventHandler, navigator, ()->gameLoop.stop(), gameService);
        berryBushWorld.start();
        gameLoop = new FancyAnimationTimer() {
            @Override
            protected void handle(double deltaInSec) {
                berryBushWorld.render(getGraphicsContext());
            }
        };
        gameLoop.start();
    }

    @Override
    public void receive(IGameService gameService) {
        this.gameService = gameService;
    }
}
