package it.aren.model;

import java.util.Optional;

import it.aren.Observer;
import it.aren.common.ApplicationState;
import it.aren.model.event.EventObservable;
import it.aren.model.game.Block;
import it.aren.core.GameFactory;
import it.aren.model.event.TransportEvent;
import it.aren.model.input.InputController;

/**
 * The class that manages the state of the game.
 */
public class GameState implements Observer{
    private final World world;
    private final EventObservable eventObservable;
    private final InputController controller;

    /**
     * Creates a new {@link World} object, the {@link Player} and loads the {@link GameMap}.
     * @param observable
     */
    public GameState(final EventObservable observable) {
        this(observable, new InputController() {
            @Override
            public void update(String toUpdate) {

            }
        });
    }

    public GameState(final EventObservable observable, final InputController inputController) {
        this.eventObservable = observable;
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
    public final void update() {
        switch (this.eventObservable.getState()){
            case GAME:
                this.processInput();
                this.world.updateState();
                if (this.world.playerCollide().isPresent()
                        && this.world.playerCollide().get().getEvent() instanceof TransportEvent) {
                    this.world.playerCollide().get().getEvent().launch(this);
                }
                break;
            case GAME_DIALOG:
                if (this.controller.getAction().equals(InputController.ON_CLOSE_DIALOG)) {
                    this.world.setDialog(null);
                    this.eventObservable.setState(ApplicationState.GAME);
                }
                break;
            default:
                break;
        }

    }

    /**
     * Check if the {@link Player} is interacting and update the input.
     * @param controller
     */
    public void processInput() {
        if (controller.getAction().equals(InputController.INTERACT)) {
            final Optional<Block> block = this.getWorld().playerCollide();
            if (block.isPresent() && !block.get().getEvent().isAlreadyLunch()) {
                block.get().getEvent().launch(this);
                this.eventObservable.setState(ApplicationState.GAME_DIALOG);
            }
        } else {
            world.getPlayer().update(GameComponent.INPUT,controller);
        }
    }

    /**
     * Create the {@link Dialog} to show.
     * @param text the message to display
     */
    public final void addDialog(final String text) {
        this.world.setDialog(GameFactory.createDialog(text));
    }

    public ApplicationState getState() {
        return this.eventObservable.getState();
    }

    public void setState(ApplicationState gameDialog) {
        this.eventObservable.setState(gameDialog);
    }
}
