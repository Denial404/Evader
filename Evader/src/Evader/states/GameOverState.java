/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * State when game is finished
 */
package Evader.states;

import Evader.map.Map;
import Evader.graphics.Assets;
import Evader.graphics.Text;
import Evader.utils.Utils;
import Evader.main.Handler;
import Evader.ui.ClickListener;
import Evader.ui.UIManager;
import Evader.ui.UIImageButton;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class GameOverState extends State {

    public static UIManager uiManager;
    private int highScore;

    // contructor for game over screen
    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        highScore = loadHighScore(); // displays current highscore
        
        // user wants to click the menu button in the bottom right corner
        uiManager.addObject(new UIImageButton(720, 520, 121, 69, Assets.menuButtons, new ClickListener() {
            @Override
            public void onClick() {
                // counter to 0
                handler.getGame().setCounter(0);
                // cooldown to 10
                handler.getGame().setCoolDown(10);
                // sets player speed back to default
                handler.getMap().getSpawner().getEntityManager().getPlayer().setSpeed(5);
                // resets points
                handler.getMap().setPoints(0);
                // resets player's position back to the middle of the ground
                handler.getMap().getSpawner().getEntityManager().getPlayer().setXPos(Map.spawnX);
                handler.getMap().getSpawner().getEntityManager().getPlayer().setYPos(Map.spawnY);
                // resets entities and items
                handler.getMap().getSpawner().getEntityManager().clearEnemies();
                handler.getMap().getSpawner().getItemManager().getItems().clear();
                handler.getMap().getSpawner().setItem(false);
                // reset hearts
                handler.getMap().setWidth(5);
                handler.getMouseManager().setUIManager(MenuState.uiManager);
                // reset enemy count so the early game is not difficult
                handler.getMap().getSpawner().setEnemyCount(0);
                // change state to menuState
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    public void update() {
        // load in new value of highscore if it gets surpassed
        if (highScore < handler.getMap().getPoints()) {
            outPutHighScore(handler.getMap().getPoints()); // get points of new highscore
            highScore = loadHighScore(); // new highscore
        }
        uiManager.update(); // update uiManager
        reset();
    }

    public void render(Graphics g) {
        g.drawImage(Assets.deadscreen, 0, 0, null);
        // displays Score: and the numerical score obtained last run
        Text.drawString(g, "Score: " + handler.getMap().getPoints(), 450, 450, true, Color.RED, Assets.futur48);
        // displays highscore achieved
        Text.drawString(g, "Highscore: " + highScore, 450, 540, true, Color.RED, Assets.futur48);
        // informs users that they can press space to restart
        Text.drawString(g, "PRESS SPACE TO PLAY AGAIN", 450, 300, true, Color.GREEN, Assets.futur24);
        uiManager.render(g); // render images
    }
    
    // reset method for when space is pressed in the GameOverState
    private void reset() {
        if (handler.getKeyManager().space) {
            // counter to 0
            handler.getGame().setCounter(0);
            // time elapsed to 0
            handler.getGame().setCoolDown(10);
            // sets player speed back to default
            handler.getMap().getSpawner().getEntityManager().getPlayer().setSpeed(5);
            // resets points
            handler.getMap().setPoints(0);
            // resets player's position back to the middle of the ground
            handler.getMap().getSpawner().getEntityManager().getPlayer().setXPos(Map.spawnX);
            handler.getMap().getSpawner().getEntityManager().getPlayer().setYPos(Map.spawnY);
            // resets entities and items
            handler.getMap().getSpawner().getEntityManager().clearEnemies();
            handler.getMap().getSpawner().getItemManager().getItems().clear();
            handler.getMap().getSpawner().setItem(false);
            // reset hearts
            handler.getMap().setWidth(5);
            handler.getMouseManager().setUIManager(null);
            // reset enemy count so the early game is not difficult
            handler.getMap().getSpawner().setEnemyCount(0);
 
            // changes to gameState
            State.setState(handler.getGame().gameState);
        }
    }

    // load highscore file in resource folders
    private int loadHighScore() {
        // highscore accesses the text file and gets the highscore
        String score = Utils.loadFileAsString("res//highscore//highscore.txt");
        return Utils.parseInt(score.trim());//trim removes any spaces
    }

    // puts highscore in highscore.txt
    private void outPutHighScore(int highScore) {
        // converts the highscore to a string so that we can store it in the .txt file
        String score = Integer.toString(highScore);
        Utils.outPutStringAsFile("res//highscore//highscore.txt", score);
    }

}
