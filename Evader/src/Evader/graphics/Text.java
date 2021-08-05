/*
 * Fred Fan and Daniel Peng
 * Jan 13, 2021
 * Drawing text class for whenever we want to use our fonts
 */
package Evader.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class Text {
    
    // drawString can "draw"/use our font to create lines of text
    public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font) {
        g.setColor(c); // colour of your desired text, ex: RED, BLACK, BLUE, etc.
        g.setFont(font); // type of font
        int x = xPos; // X position of where you want to put your text
        int y = yPos; // Y position of where you want to put your text

        // draw from center
        if (center) {
            // pixel width
            FontMetrics fm = g.getFontMetrics(font);
            x = xPos - fm.stringWidth(text) / 2;
            // pixel height
            y = (yPos - fm.getHeight() / 2) + fm.getAscent();
        }
        // draw String
        g.drawString(text, x, y);
    }
}
