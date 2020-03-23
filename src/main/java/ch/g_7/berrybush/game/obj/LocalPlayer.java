package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.framework.render.Camera;

public class LocalPlayer extends Player {

    private final Camera camera;

    public LocalPlayer(float x, float y, Camera camera) {
        super(x, y);
        this.camera = camera;
    }

    @Override
    public void update(double deltaSeconds) {
        super.update(deltaSeconds);
        camera.getPosition().set(getTransform().getPosition());
    }
}
