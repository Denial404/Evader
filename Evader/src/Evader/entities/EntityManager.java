/*
 * Fred Fan and Daniel Peng
 * Jan 12, 2021
 * Entity Manager class stores enemies and our player
 */
package Evader.entities;

import Evader.map.Map;
import Evader.entities.creatures.Player;
import Evader.main.Handler;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author FRED
 */
public class EntityManager {

    // makes things more efficient we don't have to update every single entity, we just keep updating this class which does it for us
    private Handler handler;
    private Player player;
    // store all of our other enemies
    public static ArrayList<Entity> entities;
    
    // EntityManager constructor 
    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>(); // put all entities in an Arraylist
        addEntity(player);
    }

    public void update() {
        // loops through my entities arraylist and updates each one, but if it's not active (hits the ground or player) we remove it
        Iterator<Entity> it = entities.iterator();

        // keep going if iterator has entities
        while (it.hasNext()) {
            Entity e = it.next(); 
            e.update(); // update all variables the entities

            if (!e.isActive()) {
                it.remove(); // iterator doesn't have entities
            }
        }
    }  
    
    // render all the entities to the screen
    public void render(Graphics g) {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.render(g);
        }
    }

    public void addEntity(Entity e) {
        // add entity to list
        entities.add(e);
    }

    // clear enemies, useful for rainbow item
    public void clearEnemies() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);

            if (e.isEnemy()) {
                e.setActive(false);
            }
        }
    }

    // add 1 health, useful for jug item
    public void heal() {
        Map.width++;
    }

    // getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}
