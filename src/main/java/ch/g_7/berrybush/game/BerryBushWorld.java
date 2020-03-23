package ch.g_7.berrybush.game;


import ch.g_7.berrybush.common.KeyInputManager;
import ch.g_7.berrybush.common.Navigator;
import ch.g_7.berrybush.common.Util;
import ch.g_7.berrybush.framework.GameWorld;
import ch.g_7.berrybush.game.controller.Controller;
import ch.g_7.berrybush.game.controller.KeyController;
import ch.g_7.berrybush.game.obj.*;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.main.Resource;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class BerryBushWorld extends GameWorld {

    private final List<Controller> controllers;

    private final KeyInputManager keyInputManager;
    private final Navigator navigator;

    public BerryBushWorld(KeyInputManager keyInputManager, Navigator navigator, Runnable stopper) {
        super(stopper);
        this.keyInputManager = keyInputManager;
        this.navigator = navigator;
        this.controllers = new ArrayList<>();
    }

    public void load() {
        Player player1 = new LocalPlayer(0,0, camera);
        KeyController keyController = new KeyController(player1);
        keyInputManager.add(keyController);
        controllers.add(keyController);
        add(player1);


        for (int i = 0; i < 30; i++) {
            add(new Tree(Util.random(-Const.SCREEN_WIDTH, Const.SCREEN_WIDTH), Util.random(-Const.SCREEN_HEIGHT, Const.SCREEN_HEIGHT)));
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.drawImage(Resource.GAME_BACKGROUND, 0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        super.render(gc);
    }

    @Override
    public void update(double deltaSeconds) {
        super.update(deltaSeconds);
        for (Controller controller : controllers) {
            controller.update(deltaSeconds);
        }
    }
}
