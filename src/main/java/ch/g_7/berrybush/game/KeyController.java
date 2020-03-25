package ch.g_7.berrybush.game;

import ch.g_7.berrybush.common.KeyListener;
import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.player.IPlayerService;
import javafx.scene.input.KeyEvent;

public class KeyController implements KeyListener, Updatable {

    private final Localizable controllable;

    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;
    private boolean isUpPressed = false;
    private boolean isDownPressed = false;

    public KeyController(Localizable controllable) {
        this.controllable = controllable;
    }

    @Override
    public void update(double deltaSeconds) {
        if(isDownPressed){
            controllable.getTransform().getPosition().y -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isUpPressed){
            controllable.getTransform().getPosition().y += Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isRightPressed){
            controllable.getTransform().getPosition().x -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(isLeftPressed){
            controllable.getTransform().getPosition().x += Const.MOVEMENT_SPEED * deltaSeconds;
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
