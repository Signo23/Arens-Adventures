package it.aren.model;

import java.util.Optional;

import it.aren.Observable;
import it.aren.common.ApplicationState;
import it.aren.model.game.Block;
import it.aren.core.GameFactory;
import it.aren.model.event.TransportEvent;
import it.aren.model.input.InputController;

/**
 * The class that manages the state of the game.
 */
public class GameState extends Observable<ApplicationState>{
    private final World world;
    private final InputController controller;

    public GameState(final InputController inputController) {
        super();
        this.controller = inputController;
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
    public void next(ApplicationState state) {
        super.next(state);
        switch (state){
            case GAME:
                this.processInput();
                this.world.updateState();
                if (this.world.playerCollide().isPresent()
                        && this.world.playerCollide().get().getEvent() instanceof TransportEvent) {
                    this.world.playerCollide().get().getEvent().launch(this);
                }
                break;
            case GAME_DIALOG:
                processDialogInput();
                break;
            default:
                break;
        }
    }

    /**
     * Check if the {@link Player} is interacting and update the input.
     * @param controller
     */
    private void processInput() {
        if (controller.getAction(InputController.INTERACT)) {
            final Optional<Block> block = this.getWorld().playerCollide();
            if (block.isPresent() && !block.get().getEvent().isAlreadyLunch()) {
                block.get().getEvent().launch(this);
            } else {
                controller.update(InputController.INTERACT, false);
            }
        }
        world.getPlayer().update(GameComponent.INPUT,controller);
    }

    private void processDialogInput(){
        if (!controller.getAction(InputController.INTERACT)) {
            getWorld().setDialog(null);
            next(ApplicationState.GAME);
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
