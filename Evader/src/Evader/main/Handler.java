/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2021
 * Handler class which takes in a game object to pass the handler
 */
package Evader.main;

import Evader.input.KeyManager;
import Evader.input.MouseManager;
import Evader.map.Map;

/**
 *
 * @author FRED
 */
public class Handler {

    private Game game;
    private Map map;

    // pass one object to run game state, makes things more efficient
    public Handler(Game game) {
        this.game = game;
    }
    
    // getters and setters
    // allows you to control the key manager
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    // allows you to control the mouse manager
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    // returns width of the game
    public int getWidth() {
        return game.getWidth();
    }

    // returns height of the game
    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

}
