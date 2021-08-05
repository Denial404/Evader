/*
 * Fred Fan and Daniel Peng
 * Jan 14, 2021
 * UIManager class to manage all UI components
 * Episode 30 of CodeNMore's Beginner 2D Game Programming tutorial explains UI creation:
   https://www.youtube.com/watch?v=CZ3TbnXLdW4&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=30
 */
package Evader.ui;

import Evader.main.Handler;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class UIManager {

    private Handler handler;
    // an Arraylist of all the objects we want to update and render
    private ArrayList<UIObject> objects;
    
    // constructor for UIManager, similar to EntityManager class
    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<>();
    }
    
    public void update() {
        // for every single object in the objects Arraylist, we update
        for (UIObject o : objects) {
            o.update();
        }
    }

    public void render(Graphics g) {
        // for every single object in the objects Arraylist, we draw to screen
        for (UIObject o : objects) {
            o.render(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        // call onMouseMove method if it happens
        for (UIObject o : objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e) {
        // call onMouseRelease method if it happens
        for (UIObject o : objects) {
            o.onMouseRelease(e);
        }
    }
    
    // adding objects to the Arraylist
    public void addObject(UIObject o) {
        objects.add(o);
    }

    // removing objects from the Arraylist
    public void removeObject(UIObject o) {
        objects.remove(o);
    }

    // getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
}
