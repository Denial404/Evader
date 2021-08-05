/*
 * Fred Fan and Daniel Peng
 * Jan 8, 2020
 * Creatures abstract class determines player's starting health, speed, etc.
 */
package Evader.entities.creatures;

import Evader.entities.Entity;
import Evader.main.Handler;

/**
 *
 * @author FRED
 */
public abstract class Creatures extends Entity {

    // player starts with this amount of health and speed
    public static final int DEFAULT_HEALTH = 5;
    public static final float DEFAULT_SPEED = (float) 5.0;
    // resizeability of entities, if necessary
    public static final int DEFAULT_CREATURE_WIDTH = 50;
    public static final int DEFAULT_CREATURE_HEIGHT = 50;

    protected int health;
    // how fast player moves
    protected float speed;
    protected float xMove, yMove;
    
    // Creatures constructor
    public Creatures(Handler handler, float x, float y, int width, int height) {
        // creatures are a part of entitites as well, so super this
        super(handler, x, y, width, height);
        // set our variables for a default creature
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    // moves player
    public void move() {
        XMove();
        YMove();
    }
    
    // move in x/horizontal direction
    public void XMove() {
        x += xMove;
    }

    // move in y/vertical direction
    public void YMove() {
        y += yMove;
    }
    
    // boolean for if a creature is an enemy or not
    public abstract boolean isEnemy();

    // getters and setters for variables if used
    // get health for creature (player)
    public int getHealth() {
        return health;
    }
    
    // set health for creature (player)
    public void setHealth(int health) {
        this.health = health;
    }
    
    // get speed of a creature
    public float getSpeed() {
        return speed;
    }
    
    // set speed of a creature
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    public float getXMove() {
        return xMove;
    }

    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    public float getYMove() {
        return yMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }
}
