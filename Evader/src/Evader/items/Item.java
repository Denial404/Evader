/*
 * Fred Fan and Daniel Peng
 * Jan 15, 2021
 * Item class to outline use of items
 */
package Evader.items;

import Evader.main.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author FRED
 */
public abstract class Item {
    // stores all the different items with different id's
    public static Item[] items = items = new Item[256];

    // size of items
    public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
    
    // access the variables we need 
    protected Handler handler;
    protected BufferedImage texture; // which item
    protected final int id; // item id
    
    // hitbox for the item 
    protected Rectangle bounds;
    protected int x, y;
    protected boolean pickedUp = false; // boolean false at start, no one has picked up

    // item constructor
    public Item(BufferedImage texture, int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.id = id;
        // bounds should be a rectangle around the item
        bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);

        items[id] = this;
    }
    
    // update repetitively 
    public abstract void update();
    
    // render the graphics to the screen
    public abstract void render(Graphics g);
    
    // place the item in a x and y position on the map
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    public abstract void collected();

    // if player touches item return true
    public boolean isPickedUp() {
        if (handler.getMap().getSpawner().getEntityManager().getPlayer().getCollisionBounds().intersects(bounds)) {
            return true;
        }
        return false;
    }
    
    // getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
