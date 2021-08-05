/*
 * Fred Fan and Daniel Peng
 * Jan 6, 2020
 * Access spritesheet class
 * http://pixelartmaker.com/ used to make custom sprites (ex: falling objects)
 */
package Evader.graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author FRED
 */
public class SpriteSheet {

    // represent my sprite sheet in res
    private BufferedImage sheet;
    
    // getter to crop from the spritesheet
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    // get only a certain part of sprite sheet so we can access individual images
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
