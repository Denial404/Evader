/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2021
 * Hearts class that extends Tiles, to display number of hearts on the screen
 */
package Evader.tiles;

import Evader.graphics.Assets;

/**
 *
 * @author FRED
 */
public class Hearts extends Tiles {
    
    // small hearts constructor
    public Hearts(int id) {
        super(Assets.heart, id); // picture of heart
    }

}
