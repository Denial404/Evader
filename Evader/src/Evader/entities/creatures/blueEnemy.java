/*
 * Fred Fan and Daniel Peng
 * Jan 12, 2021
 * Blue enemy class describes attributes for the blue falling object
 */
package Evader.entities.creatures;

import Evader.graphics.Assets;
import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class blueEnemy extends Enemy {

    // constructor for blue enemy
    public blueEnemy(Handler handler, float x, float y) {
        super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 5;
        bounds.y = 2;

        bounds.width = 30; // horizontally short
        bounds.height = 95; // vertically long
        speed = 12; // speed: very fast
    }
    
    // draws blue enermy onto the screen
    public void render(Graphics g) {
        g.drawImage(Assets.blue, (int) x, (int) y, null);
    }
}
