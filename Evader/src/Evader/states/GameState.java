/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * State for our gameplay
 */
package Evader.states;

import Evader.graphics.Assets;
import Evader.map.Map;
import Evader.main.Handler;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class GameState extends State {

    private Map hearts;

    // constructor for gamestate
    public GameState(Handler handler) {
        super(handler); // super calls constructor in the class we extended into
        // look at map.txt for # of hearts
        hearts = new Map(handler, "res//map//map.txt");
        handler.setMap(hearts);
    }
    
    // need to keep track of how many hearts we have throughout the game state
    @Override
    public void update() {
        hearts.update();
        
        // make sure that the player has 5 hearts at the start of the game
        if (Map.points == 10) {
            handler.getMap().setWidth(5);
        }
        
        // if the player has 0 hearts, state becomes gameOverState
        if (Map.width == 0) {
            State.setState(handler.getGame().gameOverState);
            handler.getMouseManager().setUIManager(GameOverState.uiManager);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null); // draw background
        g.drawImage(Assets.cd, 800, 100, null); // draw the cooldown bar
        hearts.render(g); // draw the hearts
    }
}
