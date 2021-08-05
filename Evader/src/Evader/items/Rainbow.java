/*
 * Fred Fan and Daniel Peng
 * Jan 18, 2021
 * Rainbow item - clears the current screen of all falling objects
 */
package Evader.items;

import Evader.graphics.Assets;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class Rainbow extends Item {
    
    // constructor for rainbow item
    public Rainbow(int id, int x, int y) {
        super(Assets.rainbow, 0, x, y);
    }
    
    // update for when the player has touched/collected the item on the ground
    public void update() {
        collected();
    }
    
    // draw the image to the screen when it appears
    public void render(Graphics g) {
        g.drawImage(texture, x, y, 40, 40, null); // dimensions of item

    }

    public void collected() {
        // if the player has came into contact with the item...
        if (isPickedUp() == true) {
            // all of the falling objects on the current screen are cleared
            handler.getMap().getSpawner().getEntityManager().clearEnemies();
            handler.getMap().getSpawner().setItem(false);
        }
    }

}
