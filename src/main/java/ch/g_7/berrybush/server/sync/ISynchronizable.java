package ch.g_7.berrybush.server.sync;

import java.io.Serializable;

public interface ISynchronizable<T extends Serializable> {

    void applyRemoteData(T t);

    T getRemoteData();

}
