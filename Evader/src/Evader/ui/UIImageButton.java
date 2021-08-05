/*
 * Fred Fan and Daniel Peng
 * Jan 14, 2021
 * UIImageButton class to update and render buttons out of images
 */
package Evader.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Daniel
 */
public class UIImageButton extends UIObject {
    // we can put 2 buttons in an array
    // 1 button is what it looks like when it is not hovered over, other is when it is hovered
    private BufferedImage[] images;
    private ClickListener clicker;
    
    // constructor for UIImageButton
    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height); // as a UIObject they have the same components
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void update() {

    }
    
    // draw images to screen
    @Override
    public void render(Graphics g) {
        // displays hovering image, second cropped image in the array
        if (hovering) {
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
          // non-hovering image, first cropped image in the array
        } else {
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick(); // create multiple UIImage buttons and pass in different images
    }

}
