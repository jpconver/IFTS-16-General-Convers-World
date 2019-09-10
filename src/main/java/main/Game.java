package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import input.KeyManager;
import main.Handler;
import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import states.GameState;
import states.State;

public class Game implements Runnable {

    private String title;
    private int width;
    private int height;
    private boolean running;
    private Thread thread;
    private BufferStrategy bs;
    public State gameState;
    private Handler handler;
    private Display display;
    private GameCamera gameCamera;
    private Graphics g;
    private KeyManager keyManager;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    @Override
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
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

    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        if (State.getState() != null) {
            State.getState().render(g);
        }
        bs.show();
        g.dispose();
    }

    public void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        gameState = new GameState(handler);
        State.setState(gameState);
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

}
