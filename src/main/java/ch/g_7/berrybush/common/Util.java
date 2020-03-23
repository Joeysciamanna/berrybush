package ch.g_7.berrybush.common;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Util {


    public static int random(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static <T> T randomFormList(List<T> list){
        int i = random(0, list.size() - 1);
        return list.get(i);
    }

    @SafeVarargs
    public static <T> T randomFormList(T... ts){
        return randomFormList(Arrays.asList(ts));
    }

}
