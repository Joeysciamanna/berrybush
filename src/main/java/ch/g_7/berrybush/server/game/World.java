package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.framework.IEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class World {

    private final List<IEntity> entities;


    public World() {
        entities = new ArrayList<>();
    }


    public void safeForEach(Consumer<IEntity> consumer){
        for (IEntity gameObject : new ArrayList<>(entities)) {
            consumer.accept(gameObject);
        }
    }

    public void forEach(Consumer<IEntity> consumer){
        for (IEntity gameObject : entities) {
            consumer.accept(gameObject);
        }
    }

    public <T extends IEntity> List<T> getEntitiesOfTypeWhere(Class<T> type, Predicate<T> predicate) {
        return getEntitiesOfType(type).stream().filter(predicate).collect(Collectors.toList());
    }

    public <T extends IEntity> Optional<T> getEntityOfTypeWhere(Class<T> type, Predicate<T> predicate) {
        return getEntitiesOfType(type).stream().filter(predicate).findFirst();
    }

    @SuppressWarnings("unchecked")
    public <T extends IEntity> List<T> getEntitiesOfType(Class<T> classToFind) {
        List<T> resultList = new ArrayList<T>();
        for (Object o : entities) {
            if (classToFind.isAssignableFrom(o.getClass()))
                resultList.add((T) o);
        }
        return resultList;
    }

    public <T extends IEntity> Optional<T> getEntityOfType(Class<T> type){
        List<T> gameObjects = getEntitiesOfType(type);
        return gameObjects.isEmpty() ? Optional.empty() : Optional.of(gameObjects.get(0));
    }

    public void add(IEntity object){
        entities.add(0, object);
    }

    public void remove(IEntity object){
        entities.remove(object);
    }

    public void removeAllOfType(Class<? extends IEntity> type){
        for (IEntity gameObject : entities) {
            remove(gameObject);
        }
    }

    public void removeAll(){
        entities.clear();
    }

    public boolean contains(IEntity gameObject){
        return entities.contains(gameObject);
    }

    public List<IEntity> getEntities(){
        return entities;
    }


}
