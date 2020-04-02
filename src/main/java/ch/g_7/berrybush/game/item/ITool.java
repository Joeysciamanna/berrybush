package ch.g_7.berrybush.game.item;

import ch.g_7.berrybush.game.obj.Damagable;
import ch.g_7.berrybush.game.obj.IBeeing;

public interface ITool extends IItem {

    int useOn(Damagable damagable, IArmor armor);

    IBeeing getOwner();
}
