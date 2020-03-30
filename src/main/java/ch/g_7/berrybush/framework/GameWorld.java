package ch.g_7.berrybush.framework;

import ch.g_7.berrybush.framework.render.Camera;
import ch.g_7.berrybush.framework.render.Renderer;
import ch.g_7.berrybush.game.obj.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GameWorld {

    private final List<GameObject> gameObjects;

    protected final Camera camera;
    private final Renderer renderer;

    protected Runnable stopper;


    public GameWorld(Runnable stopper) {
        this.stopper = stopper;
        this.camera = new Camera();
        this.renderer = new Renderer(camera);
        this.gameObjects = new ArrayList<>();
    }

    protected void stop(){
        stopper.run();
        clear();
    }

    public void update(double deltaSeconds){
        for (GameObject gameObject : getGameObjects()) {
            gameObject.update(deltaSeconds);
        }
    }

    public void render(GraphicsContext gc){
        renderer.render(gameObjects, gc);
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }

    @SuppressWarnings("unchecked")
    public <T extends GameObject> List<T> getGameObjectsOfType(Class<T> classToFind) {
        List<T> resultList = new ArrayList<T>();
        for (Object o : gameObjects) {
            if (classToFind.isAssignableFrom(o.getClass()))
                resultList.add((T) o);
        }
        return resultList;
    }

    public <T extends GameObject> Optional<T> getGameObjectOfType(Class<T> type){
        List<T> gameObjects = getGameObjectsOfType(type);
        return gameObjects.isEmpty() ? Optional.empty() : Optional.of(gameObjects.get(0));
    }

    public void add(GameObject object){
        gameObjects.add(object);
    }

    public void clear(){
        gameObjects.clear();
    }

    public void remove(GameObject object){
        gameObjects.remove(object);
    }

    public void removeAll(Class<? extends GameObject> type){
        for (GameObject gameObject : getGameObjects()) {
            remove(gameObject);
        }
    }

    public boolean contains(GameObject<?> gameObject){
        return gameObjects.contains(gameObject);
    }
}
