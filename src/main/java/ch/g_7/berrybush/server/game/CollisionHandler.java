package ch.g_7.berrybush.server.game;

import ch.g_7.berrybush.framework.IEntity;
import ch.g_7.berrybush.framework.Updatable;
import ch.g_7.berrybush.game.item.ITool;
import ch.g_7.berrybush.game.obj.Damagable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class CollisionHandler implements Updatable {

    private final World world;

    public CollisionHandler(World world) {
        this.world = world;
    }

    @Override
    public void update(double deltaSeconds) {
        for (IEntity entity1 : world.getEntities()) {
            for (IEntity entity2 : world.getEntities()) {
                if(entity1.getId() != entity2.getId() && entity1.getBoundingBox().intersects(entity2.getBoundingBox()))
                    handleCollision(entity1, entity2);
            }
        }
    }

    private void handleCollision(IEntity entity1, IEntity entity2) {
        ifOneOfEachType(entity1, entity2, Damagable.class, ITool.class, Damagable::damage);
    }


    private <T, K> void ifOneOfEachType(IEntity entity1, IEntity entity2, Class<T> type1, Class<K> type2, BiConsumer<T, K> consumer){
        if ((type1.isAssignableFrom(entity1.getClass()) && type2.isAssignableFrom(entity2.getClass()))){
            consumer.accept((T) entity1,(K) entity2);
        } else if((type1.isAssignableFrom(entity2.getClass()) && type2.isAssignableFrom(entity1.getClass()))){
            consumer.accept((T) entity2,(K) entity1);
        }
    }

    private boolean oneOfEach(IEntity entity1, IEntity entity2, Predicate<IEntity> predicate1, Predicate<IEntity> predicate2){
        return (predicate1.test(entity1) && predicate2.test(entity2)) ||
                (predicate1.test(entity2) && predicate2.test(entity1));
    }

    private boolean oneOf(IEntity entity1, IEntity entity2, Predicate<IEntity> predicate){
        return predicate.test(entity1) || predicate.test(entity2);
    }

    private boolean bothOf(IEntity entity1, IEntity entity2, Predicate<IEntity> predicate){
        return predicate.test(entity1) && predicate.test(entity2);
    }
}
