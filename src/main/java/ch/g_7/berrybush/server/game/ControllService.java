package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.framework.Camera;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.main.Const;
import ch.g_7.berrybush.math.Transform;
import ch.g_7.berrybush.server.Service;

import java.rmi.RemoteException;

public class ControllService extends Service implements IControllService, Updatable {

    private Player player;
    private Camera camera;

    private boolean forward;
    private boolean backward;
    private boolean left;
    private boolean right;

    public ControllService(String name) throws RemoteException {
        super(name);
    }

    public void setPlayer(Player player){
        if(this.player != null)
            throw new IllegalStateException("Player already set");
        this.player = player;
        this.camera = new Camera();
        this.camera.setPosition(player.getTransform().getPosition());
    }

    @Override
    public void update(double deltaSeconds) {
        if(backward){
            player.getViewModel().getTransform().getPosition().y -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(forward){
            player.getTransform().getPosition().y += Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(right){
            player.getTransform().getPosition().x -= Const.MOVEMENT_SPEED * deltaSeconds;
        }
        if(left){
            player.getTransform().getPosition().x += Const.MOVEMENT_SPEED * deltaSeconds;
        }
    }

    @Override
    public Camera getCamera() throws RemoteException {
        return camera;
    }

    @Override
    public void setForward(boolean forward) {
        this.forward = forward;
    }

    @Override
    public void setBackward(boolean backward) {
        this.backward = backward;
    }

    @Override
    public void setLeft(boolean left) {
        this.left = left;
    }

    @Override
    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public void interact() throws RemoteException {

    }

    @Override
    public void shoot() throws RemoteException {

    }
}
