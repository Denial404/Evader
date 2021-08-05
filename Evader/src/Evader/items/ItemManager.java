/*
 * Fred Fan and Daniel Peng
 * Jan 15, 2021
 * Item manager that allows for the addition of items to the Arraylist
 */
package Evader.items;

import Evader.main.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author FRED
 */
public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items; // arraylist of items

    // constructor for ItemManager
    public ItemManager(Handler handler) {
        this.handler = handler;
        items = new ArrayList<Item>();
    }

    public void update() {
        // loops through my entities arraylist and updates each one
        Iterator<Item> it = items.iterator();
        // keep going if iterator has items
        while (it.hasNext()) {
            Item i = it.next();
            i.update();
            if (i.isPickedUp()) {
                it.remove();
            }
        }

    }

    // draw all of the items in the arraylist
    public void render(Graphics g) {
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            it.render(g);
        }
    }
    
    
    // add more items to the arraylist
    public void addItem(Item i) {
        i.setHandler(handler);
        items.add(i);
    }

    //getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
