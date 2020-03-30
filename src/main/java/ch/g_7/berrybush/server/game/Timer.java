package ch.g_7.berrybush.server.game;

public class Timer {

    private float deltaMillis;
    private long lastloopTime;
    private float lpsSmoothing = 0.99f;
    private int lps;

    public float loop() {
        double nanoTime = System.nanoTime();
        deltaMillis = (float) ((nanoTime - lastloopTime) / 1000000d);
        lps = (int) (lps * lpsSmoothing + (1 / (deltaMillis/1000)) * (1-lpsSmoothing));
        lastloopTime = System.nanoTime();
        return deltaMillis;
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public float getDeltaMillis() {
        return deltaMillis;
    }

    public double getDeltaSeconds() {
        return deltaMillis / 1000d;
    }


    public int getLPS() {
        return lps;
    }

    public void reset() {
        lastloopTime = System.nanoTime();
    }

    public void setLpsSmoothing(float lpsSmoothing) {
        this.lpsSmoothing = lpsSmoothing;
    }


}
