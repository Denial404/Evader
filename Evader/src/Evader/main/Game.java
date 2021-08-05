/*
 * Fred Fan and Daniel Peng
 * Dec 28, 2020
 * Game class sets up the game, runs the game and closes it
 */
package Evader.main;

import Evader.display.Display;
import Evader.graphics.Assets;
import Evader.input.KeyManager;
import Evader.input.MouseManager;
import Evader.states.CreditsState;
import Evader.states.GameOverState;
import Evader.states.GameState;
import Evader.states.InstructionsState;
import Evader.states.MenuState;
import Evader.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FRED
 */
//
public class Game implements Runnable {

    public Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    // lets our game code run seperately to make things effecient
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    // states
    public State gameState;
    public State menuState;
    public State gameOverState;
    public State instructionsState;
    public State creditsState;

    // input for game(keys)
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // handler
    private Handler handler;

    public static int skillCoolDown; // cooldown for sprint (10)
    public static int counter; // gradually goes up for points system

    // constructor for our game
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    //initialize graphics
    private void init() {
        display = new Display(title, width, height);
        display.getJFrame().addKeyListener(keyManager);
        display.getJFrame().addMouseListener(mouseManager);
        display.getJFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);

        // we run this class for the constructor to build the gamesates
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        gameOverState = new GameOverState(handler);
        instructionsState = new InstructionsState(handler);
        creditsState = new CreditsState(handler);
        State.setState(menuState); // first state on run is the menu state
    }

    // updates the location and position of objects and variables in the code
    private void update() {
        keyManager.update();
        
        // if there is a state, update it continously
        if (State.getState() != null) {
            State.getState().update();
        }
    }

    // draws graphics out so it is visible on the screen
    private void render() {
        bs = display.getCanvas().getBufferStrategy(); // tells computer how to draw things on screen
        if (bs == null) { // happens when you first start the game
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();//allows us to draw graphics for game
        // clear screen
        g.clearRect(0, 0, width, height);

        // starts drawing here
        if (State.getState() != null) {
            State.getState().render(g);
        }

        // drawing stops
        bs.show();
        g.dispose();
    }

    public void run() {
        init();
        /* fps is frames per second, we want to run our game at 60 which means calling the render and 
        update method 60 times per second. timePerUpdate is max time to run render and update method ONCE. 
        delta will be the change of time calculated by lastTime - now.
        Finally in our if statement we perform update and render if appropriate and subtract delta by 1, or else it's going to 
        run above 60 frames if the user has a really good computer. This way it runs same speed on basically any device. */
        /* Episode 10 of CodeNMore tutorial discusses this concept very well:
        https://www.youtube.com/watch?v=w1aB5gc38C8&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=10 , 
        the importance of fps has been verified by our client contact person */

        int fps = 60; // make render() and update() method run every 60 seconds
        double timePerUpdate = 1e9 / fps; // represents maximum amount of time to call update and render methods
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); // returns amount of nanoseconds system is running at
        long timer = 0;
        skillCoolDown = 10;
        counter = 0;

        // game loop while running is true
        // add to delta difference in time passed divided by timePerUpdate
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;//control variable that tells system whether or not to call update and render method
            timer += now - lastTime;
            lastTime = now;

            // decide if it needs to render&update to hit our fps goal, or not yet.
            if (delta >= 1) {
                update();
                render();
                delta--; // if we do call the methods, this resets delta again 
            }
            // after 1 second increase counter and decrease skill cooldowns
            if (timer >= 1e9) {
                if (State.getState().equals(gameState)) {
                    counter++;

                    // if the sprint cooldown is above 0, we can reduce it until it hits 0
                    // once it hits 0, we will be able to use it
                    if (skillCoolDown > 0) {
                        skillCoolDown--;
                    }
                }
                timer = 0;
            }
        }
        stop();
    }

    //starts thread
    public synchronized void start() {
        /* if the running is already true, we don't want to repeat the code below
        but if it equals to false, then we still do the code to set it running to true */
        if (running) {
            return;
        }
        
        // our thread runs the game class
        thread = new Thread(this);
        running = true;
        thread.start(); // this will start up the run method where majority of the game code will be, basically starts the game
    }

    // stops thread
    public synchronized void stop() {
        // if the game isn't running don't do the stuff below, ex: thread.join()
        if (!running) {
            return;
        }
        
        running = false;
        
        try {
            thread.join();
          // catch the exception
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // getters and setters
    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Display getDisplay() {
        return display;
    }

    public int getCoolDown() {
        return skillCoolDown;
    }

    public void setCoolDown(int coolDown) {
        this.skillCoolDown = coolDown;
    }

}
