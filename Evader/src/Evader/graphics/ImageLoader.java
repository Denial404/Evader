/*
 * Fred Fan and Daniel Peng
 * Jan 4, 2020
 * Class that loads images by finding where they are located 
 */
package Evader.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author FRED
 */
public class ImageLoader {
    // path is location of image
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path)); // returns buffered image of our loaded image in res folder
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // if we don't load image, this prevents game from running
        }
        return null;
    } 
}
