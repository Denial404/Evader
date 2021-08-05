/*
 * Fred Fan and Daniel Peng
 * Dec 28, 2020
 * Display class that ensures the user cannot resize the canvas
 */
package Evader.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author FRED
 */
public class Display {

    // displays our window for the game
    private JFrame frame;

    // graphics for our game
    private Canvas canvas;

    private String title;
    private int width, height;

    // the display constructor 
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay(); // create display with title, width and height
    }

    //for creating display
    private void createDisplay() {
        frame = new JFrame(title); // new jFrame created 
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // don't let jFrame change size
        frame.setLocationRelativeTo(null); // frame in center
        frame.setVisible(true); // set the jFrame as visible = true

        canvas = new Canvas();
        // make canvas not change in size
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack(); // fits canvas on screen
    }

    // getter for canvas
    public Canvas getCanvas() {
        return canvas;
    }

    // setter for canvas
    public JFrame getJFrame() {
        return frame;
    }
}
