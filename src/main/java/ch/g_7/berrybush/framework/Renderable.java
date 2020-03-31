package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.math.Transform;
import javafx.scene.canvas.GraphicsContext;

public interface Renderable extends Localizable {

    void draw(GraphicsContext graphicsContext);

}
