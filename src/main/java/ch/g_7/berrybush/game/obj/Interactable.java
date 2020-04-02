package ch.g_7.berrybush.game.obj;

import ch.g_7.berrybush.game.item.ITool;

public interface Interactable {

    boolean interact(IBeeing beeing, ITool tool);
}
