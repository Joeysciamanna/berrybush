package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Renderable;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

public interface IViewModel extends Localizable, Serializable, Identifiable {

    void draw(GraphicsContext gc);


}
