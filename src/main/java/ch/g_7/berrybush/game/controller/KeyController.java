package ch.g_7.berrybush.game.controller;

import ch.g_7.berrybush.common.KeyListener;
import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.main.Const;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyController extends Controller implements KeyListener {

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;
    private boolean isUpPressed = false;
    private boolean isDownPressed = false;

    public KeyController(Localizable localizable) {
        super(localizable);
    }

    @Override
    public void update(double deltaSeconds) {
        if(isDownPressed){
            localizable.getTransform().getPosition().y -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isUpPressed){
            localizable.getTransform().getPosition().y += Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isRightPressed){
            localizable.getTransform().getPosition().x -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isLeftPressed){
            localizable.getTransform().getPosition().x += Const.MOVEMENT_SPEED * deltaSeconds;
        }
    }

    @Override
    public void handle(KeyEvent event) {
        boolean pressed = event.getEventType() == KeyEvent.KEY_PRESSED;
        switch (event.getCode()) {
            case A:
                isLeftPressed = pressed;
                break;
            case D:
                isRightPressed = pressed;
                break;
            case W:
                isUpPressed = pressed;
                break;
            case S:
                isDownPressed = pressed;
                break;
        }

    }
}
