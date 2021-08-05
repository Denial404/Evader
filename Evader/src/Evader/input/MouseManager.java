/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2020
 * Mouse manager class that allows the user to press buttons
 */
package Evader.input;

import Evader.ui.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Daniel
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    // left or right mouse button pressed 
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY; // where the mouse is located X and Y
    // holds a uiManager in MouseManager to use mouse on these UI objects
    private UIManager uiManager;

    public MouseManager() {

    }
    
    // getters and setters
    public UIManager getUIManager(UIManager uiManager){
        return uiManager;
    }
    
    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }
    
    // implemented methods
    @Override
    public void mousePressed(MouseEvent e) {
        // left click
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
          // right click
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
    }
    
    // mouse released = not pressed = false
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = false;
        }
        
        // if uiManager exists
        if (uiManager != null) {
            uiManager.onMouseRelease(e); // we can release mouse
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // tracks X and Y where the mouse moves
        mouseX = e.getX();
        mouseY = e.getY();
        
        // if uiManager exists
        if (uiManager != null) {
            uiManager.onMouseMove(e); // we can move mouse
        }
    }

    // mouse methods that could be used, may not be used in this program though
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
 
    // getters
    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

}