/*
 * Fred Fan and Daniel Peng
 * Jan 14, 2021
 * UIImage class to update and render images, usually backgrounds
 */
package Evader.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Daniel
 */
public class UIImage extends UIObject {

    private BufferedImage image;
    
    // UIImage constructor
    // unlike the UIImageButton, we don't need to change colour on mouse hover
    public UIImage(float x, float y, int width, int height, BufferedImage image) {
        super(x, y, width, height); // as a UIObject they have the same components
        this.image = image;
    }

    @Override
    public void update() {

    }
    
    // draw the UIImage onto the screen
    @Override
    public void render(Graphics g) {
        // take drawImage method from Text.java to make UIImage
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }

    // we dont need need to click backgrounds
    @Override
    public void onClick() {

    }

}
