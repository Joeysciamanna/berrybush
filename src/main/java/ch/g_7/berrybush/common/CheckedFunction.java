package ch.g_7.berrybush.common;

@FunctionalInterface
public interface CheckedFunction<I,O,E extends Exception> {

    O apply(I i) throws E;
}
