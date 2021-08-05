/*
 * Fred Fan and Daniel Peng
 * Jan 13, 2020
 * Spawner class that spawns enemies and items
 */
package Evader.main;

import Evader.items.ItemManager;
import Evader.items.Jug;
import Evader.items.Rainbow;
import Evader.map.Map;
import Evader.entities.EntityManager;
import Evader.entities.creatures.Player;
import Evader.entities.creatures.blueEnemy;
import Evader.entities.creatures.greenEnemy;
import Evader.entities.creatures.yellowEnemy;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Spawner {

    // create handler
    private Handler handler;

    // manage entities and items
    private EntityManager entityManager;
    private ItemManager itemManager;
    private boolean item = false;

    // how many enemies there are 
    private int enemyCount;

    Random r = new Random(); // choose a random int

    public Spawner(Handler handler) {
        this.handler = handler;

        entityManager = new EntityManager(handler, new Player(handler, 390, 493));
        itemManager = new ItemManager(handler);
        //starts with no enemies
        enemyCount = 0;
    }

    // continuously update the spawn of enemies and items
    public void update() {
        enemySpawner();
        itemSpawner();
        itemManager.update();
        entityManager.update();
    }

    // render graphics to screen
    public void render(Graphics g) {
        itemManager.render(g);
        entityManager.render(g);
    }

    public void enemySpawner() {
        int timer = handler.getGame().getCounter();

        // maximum enemy count
        if (enemyCount <= 10) {
            enemyCount = 1 + (timer / 2);
            // increase enemy counts as timer goes on
            // more than or equal to 10 enemies
            if (enemyCount >= 10) {
                // if timer > 30 seconds
                if (timer > 30) {
                    enemyCount = 20; // 20 enemies
                    // else if timer > 45 seconds
                } else if (timer > 45) {
                    enemyCount = 35; // more enemies, etc.
                } else if (timer > 60) {
                    enemyCount = 50;
                } else if (timer > 90) {
                    enemyCount = 65;
                }
            }

        }
        // random numbers from 0 to 20
        int spot = r.nextInt(20);

        // random spawn across gamewidth
        int xSpawn = r.nextInt(handler.getWidth() - 50);

        if (enemyCount > entityManager.getEntities().size()) {
            if (spot == 0) {
                entityManager.addEntity(new yellowEnemy(handler, xSpawn, 0));
            } else if (spot == 1 && timer > 5 && timer % 2 == 0) {
                // spawns enemy here after 5 seconds and if it is even
                entityManager.addEntity(new greenEnemy(handler, xSpawn - 50, 0));
            } else if (spot == 2 && timer > 10 && timer % 3 == 0) {
                // spawns enemy here after 10 seconds and if it is divisible by 3
                entityManager.addEntity(new blueEnemy(handler, xSpawn - 50, 0));
            }
        }
    }

    // spawns items
    public void itemSpawner() {
        int xSpawn;

        if (!item) {
            xSpawn = r.nextInt(handler.getWidth() - 64);
            // random item spawns
            int rand = r.nextInt(1000);

            // if random int is 0 or 2 and health is less than 5
            if ((rand == 0 || rand == 2) && Map.width < 5) {
                // only spawn hearts if player's health is less than max
                itemManager.addItem(new Jug(1, xSpawn, handler.getHeight() - 100));
                item = true;
                // else if random int is 1 or 3
            } else if (rand == 1 || rand == 3) {
                // rainbow block spawn
                itemManager.addItem(new Rainbow(0, xSpawn, handler.getHeight() - 100));
                item = true;
            }
        }
    }

    // getters and setters
    public EntityManager getEntityManager() {
        return entityManager;
    }

    // retrieve how many enemies there are 
    public int getEnemyCount() {
        return enemyCount;
    }

    // we can reset this to 0 once a player restarts
    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    // get item manager
    public ItemManager getItemManager() {
        return itemManager;
    }

    // set items
    public void setItem(boolean item) {
        this.item = item;
    }
}
