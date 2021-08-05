/*
 * Fred Fan and Daniel Peng
 * Jan 11, 2021
 * Tiles class for background, I'll use this mainly to display hearts
 */
package Evader.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author FRED
 */
public class Tiles {

    // lets other classes access tiles
    // create list of tiles
    public static Tiles[] tiles = new Tiles[256];
    public static Tiles heartTile = new Hearts(0);

    //we can change size of hearts if we want
    public static final int TILEWIDTH = 40, TILEHEIGHT = 40;
    
    protected BufferedImage texture; // our picture
    protected final int id; // hearts will have different id
    
    // constructor for Tiles
    public Tiles(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id; // pick the specific id you want
        tiles[id] = this; // makes it so Tiles[0] equal to a heart tile
    }

    public void update() {

    }

    // draw the tiles onto the screen
    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    // if you want to add a tile player can't pass through, this is method helps
    public boolean isSolid() {
        return false;
    }

    // get ID of tile
    public int getId() {
        return id;
    }
}
