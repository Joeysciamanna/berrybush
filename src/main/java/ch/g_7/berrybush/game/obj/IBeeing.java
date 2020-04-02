package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.game.item.IItem;

public interface IBeeing extends Localizable {

    void applyMagic();

    void pickUp(IItem item);

}
