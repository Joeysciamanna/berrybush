package ch.g_7.berrybush.game.obj.create;

import ch.g_7.berrybush.framework.GameObject;
import ch.g_7.berrybush.framework.GameObjectData;
import ch.g_7.berrybush.game.obj.Player;
import ch.g_7.berrybush.game.obj.Tree;

public class GameObjectFactory {



    public static GameObject getGameObject(GameObjectData data){
        switch (data.getType()){
            case TREE:
                return new Tree(data.getPosition());
            case CHEST:
            case PLAYER:
                Player player = new Player(data.getPosition(), );

        }
        throw new IllegalArgumentException("No GameObject of type ["+data.getType()+"]");
    }
}
