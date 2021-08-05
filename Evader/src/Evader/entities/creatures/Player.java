/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * Player class that checks movement of the player and collison with other entities 
 */
package Evader.entities.creatures;

import Evader.graphics.Assets;
import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class Player extends Creatures {
    
    // constructor for Player
    public Player(Handler handler, float x, float y) {
        // Player extends Creatures, so super the creatures constructor
        super(handler, x, y, Creatures.DEFAULT_CREATURE_WIDTH, Creatures.DEFAULT_CREATURE_HEIGHT);

        // bounding box for checking collision with other entities
        bounds.x = 32; // how far right box is from where player is drawn
        bounds.y = 15; // how far down box is from where player is drawn

        //width and height of the box
        bounds.width = 39;
        bounds.height = 79;

    }

    // have the render and update methods because player isn't an abstract class, only 1 player
    public void update() {
        // check these methods constantly so we can get accurate changes
        getInput(); // what keys have been pressed and what they do
        move(); // movement of player
        checkBounds(); // check if player is going to go outside the jFrame
        isEnemy(); // check if player has hit enemy or not
    }

    // handles key inputs
    private void getInput() {
        xMove = 0;
        yMove = 0;

        // if the O button is pressed
        if (handler.getKeyManager().O && handler.getMap().getCD().equals("Up!")) {
            changeSpeed();
        }

        // resets speed after 3 seconds
        if (handler.getGame().getCoolDown() == 7) {
            speed = DEFAULT_SPEED;
        }

        // if right key/D is pressed, player moves right
        if (handler.getKeyManager().right) {
            xMove = speed;
        }

        // if left key/A is pressed, speed will be negative and thus moves player left across the game
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }

    }

    // need to check bounds or else the player will be able to move outside the frame
    private void checkBounds() {
        // right side bounds for player when moving across the screen
        if (this.getXPos() + this.getWidth() >= 860) {
            this.setXPos(810);
        }
        
        // left side bounds for player when moving across the screen
        if (this.getXPos() <= -15) {
            this.setXPos(-15);
        }
    }

    public void render(Graphics g) {
        //we used floats earlier for position, because it runs our game smoother, since there's still space between 2 pixels, not always just whole integers
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
    
    // change the speed when the player presses O (sprint)
    private void changeSpeed() {
        // speed goes from 5 to 8, meaning that the player moves faster
        handler.getMap().getSpawner().getEntityManager().getPlayer().setSpeed(8);
        handler.getGame().setCoolDown(10); // sprint gets put on cooldown for 10 seconds
    }
    
    // check if entity is an enemy or not
    public boolean isEnemy() {
        return false;
    }

}
