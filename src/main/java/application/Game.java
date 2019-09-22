package application;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * The Game class is responsible for executing the main loop of the game and
 * call the tick and render methods of related objects at a constant time
 *
 * @author jpconver
 *
 */
public class Game implements Runnable {

    private boolean running;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private int framesPerSecond;

    public Game(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    /*
     * Call tick() and render() methods at a constant framesPerSecond executions per
     * second
     */
    @Override
    public void run() {
        double timePerTick = 1000000000 / framesPerSecond;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    /**
     * call tick methods of keyManager and world
     */
    private void tick() {
        Application.getInstance().getKeyManager().tick();
        Application.getInstance().getWorld().tick();
    }

    /**
     * clear the screen and call render method of the world
     */
    private void render() {
        bs = Application.getInstance().getDisplay().getCanvas().getBufferStrategy();
        if (bs == null) {
            Application.getInstance().getDisplay().getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Application.getInstance().getDisplay().getWidth(), Application.getInstance().getDisplay().getHeight());
        Application.getInstance().getWorld().render(g);
        bs.show();
        g.dispose();
    }

    /**
     * call run method in a new thread
     */
    public void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * stop the thread
     */
    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
