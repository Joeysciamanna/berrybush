package ch.g_7.berrybush.common;

import ch.g_7.berrybush.main.Const;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasScene extends BaseScene {

    private Canvas canvas;

    public CanvasScene(Navigator navigator) {
        super(new Group(), navigator);
        initCanvas();
    }

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
