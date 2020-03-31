package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.game.obj.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class World {

    private final List<GameObject> gameObjects;


    public World() {
        gameObjects = new ArrayList<>();
    }


    public void safeForEach(Consumer<GameObject> consumer){
        for (GameObject gameObject : new ArrayList<>(gameObjects)) {
            consumer.accept(gameObject);
        }
    }

    public void forEach(Consumer<GameObject> consumer){
        for (GameObject gameObject : gameObjects) {
            consumer.accept(gameObject);
        }
    }

    public <T extends GameObject> List<T> getGameObjectsOfTypeWhere(Class<T> type, Predicate<T> predicate) {
        return getGameObjectsOfType(type).stream().filter(predicate).collect(Collectors.toList());
    }

    public <T extends GameObject> Optional<T> getGameObjectOfTypeWhere(Class<T> type, Predicate<T> predicate) {
        return getGameObjectsOfType(type).stream().filter(predicate).findFirst();
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

    public void remove(GameObject object){
        gameObjects.remove(object);
    }

    public void removeAllOfType(Class<? extends GameObject> type){
        for (GameObject gameObject : gameObjects) {
            remove(gameObject);
        }
    }

    public void removeAll(){
        gameObjects.clear();
    }

    public boolean contains(GameObject gameObject){
        return gameObjects.contains(gameObject);
    }

    public List<GameObject> getGameObjects(){
        return  gameObjects;
    }


}
