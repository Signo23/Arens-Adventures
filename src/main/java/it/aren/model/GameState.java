/**
 * 
 */
package it.aren.model;

import it.aren.common.ApplicationState;
import it.aren.core.GameFactory;
import it.aren.graphic.Texture;
/**
 * The class that manages the state of the game.
 */
public class GameState {

    private ApplicationState state;
    private final World world;

    /**
     * Creates a new world object, the player and the game map.
     */
    public GameState(final Texture texture) {
        state = ApplicationState.BOOT;
        this.world = new World();
        this.world.setPlayer(GameFactory.createPlayer(texture));
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
    
    public ApplicationState getState() {
        return this.state;
    }
    
    public void setState(final ApplicationState as) {
        this.state = as;
    }
    
    public void addDialog() {
        this.world.setDialog(GameFactory.createDialog());
    }
}
