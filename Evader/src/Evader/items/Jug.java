/*
 * Fred Fan and Daniel Peng
 * Jan 17, 2021
 * Jug item - pick up for +1 heart
 */
package Evader.items;

import Evader.graphics.Assets;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class Jug extends Item {
    
    // constructor for Jug
    public Jug(int id, int x, int y) {
        // super because the jug is an item, Assets.jug is the sprite of a jug
        super(Assets.jug, 1, x, y); 
    }
    
    // update the screen once the jug has been collected
    @Override
    public void update() {
        collected();
    }
    
    // draws the jug to the screen using the appropriate dimensions
    @Override
    public void render(Graphics g) {
        g.drawImage(texture, x, y, 30, 40, null);
    }
    
    // method to see if the jug is collected
    @Override
    public void collected() {
        // if jug is collected
        if (isPickedUp() == true) {
            // the player is "healed" (+1 one heart to hearts system)
            handler.getMap().getSpawner().getEntityManager().heal();
            handler.getMap().getSpawner().setItem(false); // make the item disappear
        }
    }

}
