/*
 * Fred Fan and Daniel Peng
 * Jan 7, 2020
 * Credits page
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
public class CreditsState extends State {

    public static UIManager uiManager;

    public CreditsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        
        // set background as the credits.png found in res//textures folder
        uiManager.addObject(new UIImage(0, 0, 900, 650, ImageLoader.loadImage("res//textures//credits.png")));
        
        // place a small menu button in the bottom right corner of the frame
        uiManager.addObject(new UIImageButton(720, 520, 121, 69, Assets.menuButtons, new ClickListener() {
            @Override
            public void onClick() {
                // set UIManager to other state class's ui manager
                handler.getMouseManager().setUIManager(MenuState.uiManager);
                // pressing the menu button should allow us to go back to the menu
                State.setState(handler.getGame().menuState);
            }
        }));
    }

    // update the ui
    public void update() {
        uiManager.update();
    }

    // render images/ui to screen
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
