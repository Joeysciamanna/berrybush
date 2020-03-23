package ch.g_7.berrybush.common;

import ch.g_7.berrybush.main.Const;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class BaseScene extends Scene {

    protected final Navigator navigator;
    private Canvas canvas;

    public BaseScene(Navigator navigator) {
        super(new Group());
        this.navigator = navigator;
        initCanvas();
    }

    public void onOpen() { }

    public void onClose() { }

    private void initCanvas() {
        canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        ((Group)getRoot()).getChildren().add(canvas);
        canvas.setCache(true);
        canvas.setCacheHint(CacheHint.SPEED);
        canvas.setDepthTest(DepthTest.ENABLE);
    }

    protected GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }
}
