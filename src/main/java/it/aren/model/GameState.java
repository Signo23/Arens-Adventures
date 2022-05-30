/**
 * 
 */
package it.aren.model;

import java.util.Optional;

import it.aren.common.ApplicationState;
import it.aren.core.GameFactory;
import it.aren.event.EventListener;
import it.aren.graphic.Texture;
import it.aren.input.InputController;
/**
 * The class that manages the state of the game.
 */
public class GameState {

    private ApplicationState state;
    private final World world;
    private final EventListener eventListener;

    /**
     * Creates a new world object, the player and the game map.
     * @param texture 
     */
    public GameState(final Texture texture, final EventListener listener){
        this.state = ApplicationState.BOOT;
        this.eventListener = listener;
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
    
    public void processInput(final InputController controller) {
        if(controller.isIntereact()) {
            final Optional<Block> block = this.getWorld().playerCollide();
            if(!block.isEmpty()) {
                this.eventListener.notifyEvent(block.get().getEvent());
            }
            state = ApplicationState.GAME_DIALOG;
        } else {
        world.getCurrentMap().getBlocks().forEach(b -> b.updateInput(controller));
        world.getPlayer().updateInput(controller);
        }
    }
}
