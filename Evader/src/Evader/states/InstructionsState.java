/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * Instructions page detailing features of our game and a brief description
 */
package Evader.states;

import Evader.graphics.Assets;
import Evader.main.Handler;
import Evader.ui.UIImage;
import Evader.ui.UIManager;
import Evader.ui.UIImageButton;
import Evader.graphics.ImageLoader;
import Evader.ui.ClickListener;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class InstructionsState extends State {

    public static UIManager uiManager;

    public InstructionsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        
        // set background as the instructions.png found in res//textures folder
        uiManager.addObject(new UIImage(0, 0, 900, 650, ImageLoader.loadImage("res//textures//instructions.png")));
        
        // place a small menu button in the bottom right of the screen
        uiManager.addObject(new UIImageButton(720, 520, 121, 69, Assets.menuButtons, new ClickListener() {
            @Override
            public void onClick() {
                // set UIManager to other state class's ui manager
                handler.getMouseManager().setUIManager(MenuState.uiManager);
                // on click of the menu button brings us back to the menuState
                State.setState(handler.getGame().menuState);
            }
        }));
    }
    
    // update the ui
    @Override
    public void update() {
        uiManager.update();
    }
    
    // render images/ui to screen
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
