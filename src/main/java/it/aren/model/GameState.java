/**
 * 
 */
package it.aren.model;

import it.aren.core.GameFactory;
/**
 * The class that manages the state of the game.
 */
public class GameState {

    private final World world;

    /**
     * Creates a new world object, the player and the game map.
     */
    public GameState() {
        this.world = new World();
        this.world.setPlayer(GameFactory.createPlayer());
        this.world.addMap(GameFactory.loadMaps());
        this.world.setCurrentMap(0);
    }

    /**
     * Return the world.
     * @return world
     */
    public final World getWorld() {
        return this.world;
    }

    /**
     * Update the world's state.
     */
    public final void update() {
        this.world.updateState();
    }
}
