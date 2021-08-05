/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * Starting menu state
 */
package Evader.states;

import Evader.graphics.Assets;
import Evader.main.Handler;
import Evader.ui.UIImage;
import Evader.ui.UIManager;
import Evader.ui.UIImageButton;
import Evader.graphics.ImageLoader;
import Evader.graphics.Text;
import Evader.ui.ClickListener;
import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author Daniel
 */
public class MenuState extends State {

    public static UIManager uiManager;

    //constructor for startmenu state
    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        // allow for use of mouse and ui manager so you can click images
        handler.getMouseManager().setUIManager(uiManager);
        
        // background image from our res//textures folder
        uiManager.addObject(new UIImage(0, 0, 900, 650, ImageLoader.loadImage("res//textures//intro.png")));
        
        // first button below the title EVADER
        uiManager.addObject(new UIImageButton(309, 260, 270, 79, Assets.start, new ClickListener() {
            @Override
            public void onClick() {
                //  Close UIManager
                handler.getMouseManager().setUIManager(null);
                // since we're clicking the "start" button, we should go to the gameState afterwards
                State.setState(handler.getGame().gameState); 
            }
        }));
        
        // second button below start button
        uiManager.addObject(new UIImageButton(308, 360, 273, 79, Assets.instructions, new ClickListener() {
            @Override
            public void onClick() {
                //  set UIManager to other state classe's ui manager
                handler.getMouseManager().setUIManager(InstructionsState.uiManager);
                // instructions button brings us to instructionsState
                State.setState(handler.getGame().instructionsState);
            }
        }));
        
        // third button below instructions button
        uiManager.addObject(new UIImageButton(309, 460, 273, 79, Assets.credits, new ClickListener() {
            @Override
            public void onClick() {
                //  Close UIManager
                handler.getMouseManager().setUIManager(CreditsState.uiManager);
                // credits button brings us to creditsState
                State.setState(handler.getGame().creditsState);
            }
        }));
    }
    
    // update the ui constantly
    @Override
    public void update() {
        uiManager.update();
    }
    
    // draw the graphics and fonts we need to the screen
    @Override
    public void render(Graphics g) {
        uiManager.render(g);
        // drawString indicating that this is version 2.0 of our game with appropriate attributes
        Text.drawString(g, "Version 2.0", 445, 205, true, Color.BLACK, Assets.futur24);
        // Name of our group and what the program was made with at the bottom of the menu
        Text.drawString(g, "Fan and Peng Inc.     Made with Java NetBeans IDE 8.2", 450, 600, true, Color.BLACK, Assets.futur14);
    }
}
