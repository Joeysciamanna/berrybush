package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.math.Transform;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Renderer {

    private Camera camera;

    public Renderer(Camera camera) {
        this.camera = camera;
    }

    public void render(List<? extends Renderable> renderables, GraphicsContext gc){



        for (Renderable renderable : renderables) {
            gc.save();
            gc.rotate(-camera.getRotation());
            gc.translate(camera.getPosition().x + Const.SCREEN_WIDTH / 2, camera.getPosition().y + Const.SCREEN_HEIGHT / 2);
            translate(renderable.getTransform(), gc);
            renderable.draw(gc);
            gc.restore();
        }

    }

    private void translate(Transform transform, GraphicsContext gc){
        //Translate to the middle of the GameObject
        gc.translate(transform.getScale().x / 2, transform.getScale().y / 2);
        //Rotate around the middle of the GameObject
        gc.rotate(Math.toDegrees(transform.getRotation()));
        //Translate to the top left corner of the GameObject
        gc.translate(-transform.getPosition().x - transform.getScale().x, -transform.getPosition().y - transform.getScale().y);
    }

}
