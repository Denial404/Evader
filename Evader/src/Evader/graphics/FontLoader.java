/*
 * Fred Fan and Daniel Peng
 * Jan 13, 2021
 * FontLoader class to allow use of fonts
 */
package Evader.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author FRED
 */
public class FontLoader {
    public static Font loadFont(String path, float size) {
        try {
            // DeriveFont sets up font
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.exit(1); // prevents game from running 
        }
        return null;
    }
}
