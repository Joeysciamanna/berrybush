package ch.g_7.berrybush.game.controller;

import ch.g_7.berrybush.framework.Localizable;
import ch.g_7.berrybush.framework.Updatable;

public abstract class Controller implements Updatable {

    protected final Localizable localizable;

    public Controller(Localizable localizable) {
        this.localizable = localizable;
    }


}
