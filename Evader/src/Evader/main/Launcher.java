/*
 * Fred Fan and Daniel Peng
 * Dec 28, 2020
 * Launcher purely used to start the game
 */
package Evader.main;

/**
 *
 * @author FRED
 */
public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Evader", 900, 650); // set dimensions
        game.start(); // starts up game
    }
}
