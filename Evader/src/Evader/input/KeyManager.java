/*
 * Fred Fan and Daniel Peng
 * Jan 8, 2020
 * Key manager class that allows the user to move, use sprint, and restart
 */
package Evader.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author FRED
 */
public class KeyManager implements KeyListener {

    // array for keys id
    private boolean[] keys;
    // directions player can move
    public boolean left, right, O, space;

    // all possible keys on the keyboard
    public KeyManager() {
        keys = new boolean[256];
    }

    // assign booleans to their respective key id
    public void update() {
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT]; // left to move left
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT]; // right to move right
        O = keys[KeyEvent.VK_O]; // O to use sprint
        space = keys[KeyEvent.VK_SPACE];// space to restart game
    }

    // key methods
    // searches id for key to know which one is pressed
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    // once released, the key is not being pressed -> false
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }
}
