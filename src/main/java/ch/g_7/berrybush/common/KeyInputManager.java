package ch.g_7.berrybush.common;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class KeyInputManager implements EventHandler<KeyEvent> {

    private final ArrayList<KeyListener> keyListeners;

    public KeyInputManager() {
        this.keyListeners = new ArrayList<>();
    }

    @Override
    public void handle(KeyEvent event) {
        for (KeyListener keyListener : keyListeners) {
            keyListener.handle(event);
        }
    }

    public boolean add(KeyListener keyListener) {
        return keyListeners.add(keyListener);
    }
}
