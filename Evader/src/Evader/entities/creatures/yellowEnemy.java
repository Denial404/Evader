/*
 * Fred Fan and Daniel Peng
 * Jan 13, 2021
 * Yellow enemy class describes attributes for a yellow falling object
 */
package Evader.entities.creatures;

import Evader.graphics.Assets;
import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class yellowEnemy extends Enemy {
    
    // constructor for yellow enemy
    public yellowEnemy(Handler handler, float x, float y) {
        // creature attributes
        super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 2;
        bounds.y = 2;

        bounds.width = 70; // medium width
        bounds.height = 70; // medium height
        speed = 8; // speed: average
    }
    
    // draws the yellow enemy onto the screen
    public void render(Graphics g) {
        g.drawImage(Assets.yellow, (int) x, (int) y, null);
    }
}
