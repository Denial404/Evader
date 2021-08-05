/*
 * Fred Fan and Daniel Peng
 * Jan 8, 2020
 * Entity abstract class that can check collisions between entities
 */
package Evader.entities;

import Evader.main.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author FRED
 */
public abstract class Entity {

    // takes in one game object in the main class
    protected Handler handler;
    // x and y position
    protected float x, y;
    // size of entity
    protected int width, height;
    protected Rectangle bounds;
    public boolean active = true;

    //constructor for any entity, ex: player, enemy, item, etc
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height); // dimensions of object
    }

    public abstract void update();

    public abstract void render(Graphics g);

    // check if entity is enemy or not
    public abstract boolean isEnemy();

    public boolean checkEntityCollisions() {
        // loop from current entity to other entities in arraylist
        for (Entity e : handler.getMap().getEntityManager().getEntities()) {
            if (e.equals(this)) {// don't check collisions against itself
                continue;
            }

            // if entities hit the player
            if (e.getCollisionBounds().intersects(getCollisionBounds())) {
                if (handler.getMap().getSpawner().getEntityManager().getPlayer().getCollisionBounds().intersects(e.getCollisionBounds())) {
                    return true; // enemy gets removed and player can lose a heart
                }
            }
        }
        return false; // no collision
    }

    //return bounding rectangle
    public Rectangle getCollisionBounds() {
        return new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
    }

    // getters and setters for entities
    // lets other classes access private variables in this class
    public float getXPos() {
        return x;
    }

    public void setXPos(float x) {
        this.x = x;
    }

    public float getYPos() {
        return y;
    }

    public void setYPos(float y) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
