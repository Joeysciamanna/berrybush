package ch.g_7.berrybush.common;

import ch.g_7.berrybush.main.Const;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseScene extends Scene {

    protected final Navigator navigator;

    public BaseScene(Parent parent, Navigator navigator) {
        super(parent);
        this.navigator = navigator;
    }

    public void onOpen() { }

    public void onClose() { }


}
