/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;
/**
 * The class that manage the game's world.
 */
public class World {

    private Player player;
    private final List<GameMap> maps;
    private GameMap currentMap;

    /**
     * Creates a new ArrayList for the maps.
     */
    public World() {
        this.maps = new ArrayList<>();
    }

    /**
     * Return the player.
     * @return player
     */
    public final Player getPlayer() {
        return this.player;
    }
    /**
     * Set the player.
     * @param player to set
     */
    public final void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * Add a new game map to the ArrayList.
     * @param map the map to add
     */
    public final void addMap(final GameMap map) {
        this.maps.add(map);
    }
    /**
     * Return the map to view on the screen.
     * @return currentMap
     */
    public final GameMap getCurrentMap() {
        return this.currentMap;
    }
    /**
     * Set the currentMap.
     * @param index of the current map
     */
    public final void setCurrentMap(final int index) {
        this.currentMap = maps.get(index);
    }
    /**
     * Update the world's state.
     */
    public void updateState() {
        //TO DO when physic is implemented
    }
}
