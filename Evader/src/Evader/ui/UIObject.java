/*
 * Fred Fan and Daniel Peng
 * Jan 12, 2020
 * UIObject abstract class 
 */
package Evader.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

/**
 *
 * @author Daniel
 */
public abstract class UIObject {
    // variables to make our images
    protected float x, y;
    protected int width, height;
    protected boolean hovering = false;
    protected Rectangle bounds;
    
    // constructor for UI elements
    public UIObject(float x, float y, int width, int height) {
        // x and y for position
        this.x = x;
        this.y = y;
        // width and height for size
        this.width = width;
        this.height = height;
        // to know if the user's mouse is hovering over a position that has a button or not
        bounds = new Rectangle((int) x, (int) y, width, height);
    }
    
    public abstract void update(); // update UI
    
    public abstract void render(Graphics g); // draw UI to screen
    
    // every UIObject will recognize when the user clicks
    public abstract void onClick();
    
    // when user moves the mouse, we need to check if the mouse is hovering over a UIObject or not
    public void onMouseMove(MouseEvent e) {
        //  mouse hovering over button
        if (bounds.contains(e.getX(), e.getY())) {
            hovering = true;
          // else it isn't hovering over a button, hovering = false
        } else {
            hovering = false;
        }
    }
    
    // if the user is hovering over a UIObject and releases, they must have clicked
    public void onMouseRelease(MouseEvent me) {
        // button clicked
        if (hovering) {
            onClick();
        }
    }
    
    // getters and setters
    public float getX() {
        return x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public float getY() {
        return y;
    }
    
    public void setY(float y) {
        this.y = y;
    }
     
     public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }
}
