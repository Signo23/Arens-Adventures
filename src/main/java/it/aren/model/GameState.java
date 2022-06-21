package it.aren.model;

import java.util.Optional;

import it.aren.common.ApplicationState;
import it.aren.core.GameFactory;
import it.aren.event.EventListener;
import it.aren.event.TransportEvent;
import it.aren.input.InputController;
import it.aren.model.game.Block;
import it.aren.model.game.GameMap;
/**
 * The class that manages the state of the game.
 */
public class GameState {

    private ApplicationState state;
    private final World world;
    private final EventListener eventListener;

    /**
     * Creates a new {@link World} object, the {@link Player} and loads the {@link GameMap}.
     * @param listener 
     */
    public GameState(final EventListener listener) {
        this.state = ApplicationState.BOOT;
        this.eventListener = listener;
        this.world = new World();
        this.world.setPlayer(GameFactory.createPlayer());
        this.world.addMaps(GameFactory.loadMaps());
        this.world.setCurrentMap(0);
    }

    /**
     * Return the {@link World}.
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
        if (this.world.playerCollide().isPresent() && 
            this.world.playerCollide().get().getEvent() instanceof TransportEvent) {
                this.eventListener.notifyEvent(this.world.playerCollide().get().getEvent());
        }
    }

    /**
     * Return the application state.
     * @return state
     */
    public ApplicationState getState() {
        return this.state;
    }

    /**
     * Set the application state.
     * @param as
     */
    public void setState(final ApplicationState as) {
        this.state = as;
    }

    /**
     * 
     * @param controller
     */
    public void processInput(final InputController controller) {
        if (controller.isInteract()) {
            final Optional<Block> block = this.getWorld().playerCollide();
            if (!block.isEmpty() && !block.get().getEvent().isAlreadyLunch()) {
                this.eventListener.notifyEvent(block.get().getEvent());
                state = ApplicationState.GAME_DIALOG;
            }

        } else {
            world.getPlayer().updateInput(controller);
        }
    }
    
    /**
     * Create the {@link Dialog} to show.
     * @param text the message to display
     */
    public final void addDialog(final String text) {
        this.world.setDialog(GameFactory.createDialog(text));
    }
}
