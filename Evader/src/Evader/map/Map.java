/*
 * Fred Fan and Daniel Peng
 * Jan 11,2021
 * Map class to place hearts and other entities
 */
package Evader.map;

import Evader.graphics.Assets;
import Evader.graphics.Text;
import Evader.utils.Utils;
import Evader.entities.EntityManager;
import Evader.entities.creatures.Player;
import Evader.main.Game;
import Evader.main.Handler;
import Evader.main.Spawner;
import Evader.tiles.Tiles;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author FRED
 */
public class Map {
    
    private Handler handler;
    public static int width;
    // where players spawns initially
    public static int spawnX, spawnY;
    // horizontal array to display the hearts
    public static int[] hearts;
    // entities
    private EntityManager entityManager;

    private Spawner spawner;
    public static int points; // indicates how many points the player has accumulated
    private String CD; // displays a number counting down
    
    // constructor for map class
    public Map(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 390, 493));
        loadHearts(path);
        spawner = new Spawner(handler);

        // spawn in correct X and Y position
        spawner.getEntityManager().getPlayer().setXPos(spawnX);
        spawner.getEntityManager().getPlayer().setYPos(spawnY);
    }
    
    // updates the screen constantly
    public void update() {
        points = Game.counter * 10; // points of the player goes up 10 every second
        spawner.update(); // repeatedly updates the spawner 
        CD = Integer.toString(handler.getGame().getCoolDown()); // gets CD of sprint
    }

    // render all graphics as long as the player is alive
    public void render(Graphics g) {
        for (int x = 0; x < width; x++) {
            // renders how many hearts the player has 
            getTile(x).render(g, x * Tiles.TILEWIDTH, 0);
        }
        entityManager.render(g);
        spawner.render(g);
        playerPoints(g);
        skillTimer(g);
    }

    // get tiles we want from tile class
    public Tiles getTile(int x) {
        // we index the tiles array in Tiles class at the position of hearts[x]
        Tiles t = Tiles.tiles[hearts[x]];
        // we always get the heart tile, it's our only one
        if (t == null) {
            return Tiles.heartTile;
        }
        return t;
    }

    private void loadHearts(String path) {
        String file = Utils.loadFileAsString(path);
        // gets all the strings from map txt file and puts it into an array where we can access them
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);

        // starting position of player
        spawnX = Utils.parseInt(tokens[1]);
        spawnY = Utils.parseInt(tokens[2]);

        hearts = new int[width];

        for (int x = 0; x < width; x++) {
            // i add 3 because our first 3 elements were width, and spawn location of player
            hearts[x] = Utils.parseInt(tokens[x + 3]);
        }

    }

    public void playerPoints(Graphics g) {
        //renders points
        Text.drawString(g, "Points: " + points, 750, 30, true, Color.black, Assets.futur32);
    }

    // skill timer for sprint
    public void skillTimer(Graphics g) {
        // if the cooldown isn't 0, we can draw the cooldown for sprint (1 to 10)
        if (handler.getGame().getCoolDown() != 0) {
            Text.drawString(g, CD, 835, 130, true, Color.WHITE, Assets.futur24);
          // else, the use for sprint is available, indicate with "Up!"
        } else {
            CD = "Up!";
            Text.drawString(g, CD, 835, 130, true, Color.WHITE, Assets.futur24);
        }
    }

    // getters and setters
    // useful for managing entities
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    // return spawner
    public Spawner getSpawner() {
        return spawner;
    }

    // returns points
    public int getPoints() {
        return points;
    }

    // returns cooldown
    public String getCD() {
        return CD;
    }

    // set number of points achieved in the end
    public void setPoints(int points) {
        this.points = points;
    }

    // we can use this to set the number of hearts 
    public void setWidth(int width) {
        Map.width = width;
    }
}
