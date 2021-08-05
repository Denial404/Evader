/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * Game states class ex: Menu, Game, Game Over
 */
package Evader.states;

import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */

// abstract class for states, things that every state will have in common
public abstract class State {

    // manages our gamestate, which screen we want
    // in the game class, we'll only render and update if we have an acutal state
    private static State currentState = null;

    public static void setState(State state) {
        currentState = state; // change the state which starts at nothing
    }

    // return our state
    public static State getState() {
        return currentState;
    }

    protected Handler handler;

    // constructor for determining game state
    public State(Handler handler) {
        this.handler = handler;
    }

    // every state or screen will have an update that changes the variables of our objects
    public abstract void update();

    public abstract void render(Graphics g); // draws out all the updates

}
