package ch.g_7.berrybush.server.game;

import java.sql.Time;

public abstract class Loop implements Runnable {

    private final Timer timer;
    private Thread thread;
    private boolean running;

    public Loop() {
        this.timer = new Timer();
    }

    @Override
    public final void run() {
        while (running) {
            run(timer.getDeltaMillis());
            timer.sleep(5);
        }
    }

    protected abstract void run(float deltaSeconds);

    protected final void setRunning(boolean running) {
        if (running && !this.running) {
            this.running = true;
            thread = new Thread(this);
            thread.start();
        } else if (!running && this.running) {
            this.running = false;
            thread = null;
        }
    }

    public void start() {
        setRunning(true);
    }

    public void stop() {
        setRunning(false);
    }
}
