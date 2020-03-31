package ch.g_7.berrybush.game;

import ch.g_7.berrybush.common.KeyListener;
import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.server.RemoteUtil;
import ch.g_7.berrybush.server.game.IControllService;
import javafx.scene.input.KeyEvent;

public class KeyController implements KeyListener {

    private final IControllService controllService;


    public KeyController(IControllService controllService) {
        this.controllService = controllService;
    }

    @Override
    public void handle(KeyEvent event) {
        boolean pressed = event.getEventType() == KeyEvent.KEY_PRESSED;
        switch (event.getCode()) {
            case A:
                RemoteUtil.async(()->controllService.setLeft(pressed));
                break;
            case D:
                RemoteUtil.async(()->controllService.setRight(pressed));
                break;
            case W:
                RemoteUtil.async(()->controllService.setForward(pressed));
                break;
            case S:
                RemoteUtil.async(()->controllService.setBackward(pressed));
                break;
        }

    }
}
