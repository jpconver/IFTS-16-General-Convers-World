package application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The KeyManager class listens for key events and set attributes of the keys that are being pressed on every tick() call
 * @author jpconver
 *
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        upPressed = keys[KeyEvent.VK_W];
        downPressed = keys[KeyEvent.VK_S];
        leftPressed = keys[KeyEvent.VK_A];
        rightPressed = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

}