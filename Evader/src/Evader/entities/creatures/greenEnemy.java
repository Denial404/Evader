/*
 * Fred Fan and Daniel Peng
 * Jan 13, 2021
 * Green enemy class describes attributes for the green falling object
 */
package Evader.entities.creatures;

import Evader.graphics.Assets;
import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class greenEnemy extends Enemy {
    
    // constructor for green enemy
    public greenEnemy(Handler handler, float x, float y) {
        super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 2;
        bounds.y = 2;

        bounds.width = 100; // horizontally long
        bounds.height = 39; // vertically short
        speed = 4; // speed: quite slow
    }
    
    // draws the green enemy onto the screen
    public void render(Graphics g) {
        g.drawImage(Assets.green, (int) x, (int) y, null);
    }
}
