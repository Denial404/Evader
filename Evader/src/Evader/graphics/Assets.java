/*
 * Fred Fan and Daniel Peng
 * Jan 6, 2020
 * Assets class that loads all the images from our spritesheet once
 */
package Evader.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 *
 * @author FRED
 */
public class Assets {

    // pictures that need to be loaded
    public static BufferedImage player, background, blue, yellow, green, heart, introscreen, rainbow, jug, deadscreen, cd;
    public static BufferedImage[] start;
    public static BufferedImage[] instructions;
    public static BufferedImage[] credits;
    public static BufferedImage[] menu;
    public static BufferedImage[] menuButtons;

    // font and sizes we need to use for different purposes
    public static Font futur48;
    public static Font futur32;
    public static Font futur24;
    public static Font futur14;

    //init method in game class runs Assets.init once so we have all the BufferedImages for our game 
    //render in game starts drawing the images, and places them at desired locations of JFrame
    public static void init() {
        futur48 = FontLoader.loadFont("res/fonts/futur.ttf", 48);
        futur32 = FontLoader.loadFont("res/fonts/futur.ttf", 32);
        futur24 = FontLoader.loadFont("res/fonts/futur.ttf", 24);
        futur14 = FontLoader.loadFont("res/fonts/futur.ttf", 12);

        // crop out all pictures from spritesheet located in res folder under Textures
        /* used site: https://www.codeandweb.com/free-sprite-sheet-packer to place
           multiple images in one large spritesheet .png file */
        SpriteSheet pics = new SpriteSheet(ImageLoader.loadImage("res//textures//pictures.png"));
        SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("res//textures//menu.png"));
        SpriteSheet intro = new SpriteSheet(ImageLoader.loadImage("res//textures//intro.png"));
        SpriteSheet gameOver = new SpriteSheet(ImageLoader.loadImage("res//textures/gameover.png"));
        SpriteSheet dot = new SpriteSheet(ImageLoader.loadImage("res//textures//dot.png"));
        SpriteSheet mb = new SpriteSheet(ImageLoader.loadImage("res//textures//menuButtons.png"));

        // cropped pictures in the game state screen
        player = pics.crop(0, 0, 100, 100);
        background = pics.crop(1, 100, 900, 650);
        heart = pics.crop(512, 1, 60, 60);
        // different falling objects
        blue = pics.crop(102, 1, 34, 98);
        green = pics.crop(410, 3, 100, 42);
        yellow = pics.crop(905, 81, 74, 70);

        introscreen = intro.crop(0, 0, 900, 650); // introduction screen

        // start button on main menu
        start = new BufferedImage[2];
        start[0] = pics.crop(888, 2, 248, 79); // light version
        start[1] = menu.crop(2, 3, 248, 79); // dark version on hover

        instructions = new BufferedImage[2];
        instructions[0] = pics.crop(582, 3, 248, 79); // light version
        instructions[1] = menu.crop(4, 105, 248, 79); // dark version on hover

        credits = new BufferedImage[2];
        credits[0] = pics.crop(145, 8, 248, 79); // light version
        credits[1] = menu.crop(5, 210, 248, 78); // dark version on hover

        menuButtons = new BufferedImage[2];
        menuButtons[0] = mb.crop(1, 1, 121, 69); // light version
        menuButtons[1] = mb.crop(1, 84, 121, 69); // dark version on hover

        //cropped pictures of items
        jug = pics.crop(849, 3, 32, 46); // jug for +1 heart
        rainbow = pics.crop(3, 756, 56, 50); // rainbow for clear screen

        cd = dot.crop(269, 126, 66, 58); // cooldown circle
        deadscreen = gameOver.crop(0, 0, 900, 650); // gameover screen
    }

}
