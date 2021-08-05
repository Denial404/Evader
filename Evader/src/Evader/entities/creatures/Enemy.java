/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2020
 * Abstract class for different type of enemies
 */
package Evader.entities.creatures;

import Evader.map.Map;
import Evader.main.Handler;

/**
 *
 * @author FRED
 */
public abstract class Enemy extends Creatures {

    // constructor for enemies
    public Enemy(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
    
    // constantly update falling, movement and whether of not the enemy has hit something
    public void update() {
        fall();
        move();
        hit();
    }
    
    public void fall() {
        // if the falling object is above the floor, continue falling down
        if (y >= 0) {
            yMove = speed;
        }

        // if entity hits floor they dissapear
        if (y + bounds.height >= handler.getHeight() - 65) {
            active = false;
        }
    }

    public void hit() {
        // collision will remove enemy
        if (checkEntityCollisions()) {
            active = false;
            Map.width--; // reduces 1 heart of the player
        }
    }
    
    public boolean isEnemy() {
        return true;
    }
}
