package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.game.item.ITool;

public interface Damagable {

    void damage(ITool tool);

    void doBreak();

}
