package it.aren.model.event;

import java.util.Optional;

import it.aren.common.ApplicationState;
import it.aren.model.GameState;
import it.aren.model.game.GameObject;

/**
 * A class for display a message and add an {@link GameObect} to {@link Player}'s backpack.
 * Implements {@link BaseEvent}
 *
 */
public class InteractWithPlayerEvent implements BaseEvent {

    private final GameObject object;
    private final String dialog;
    private Optional<GameObject> requirement;
    private final String alternativeDialog;
    private boolean isAlreadyLunch;
    /**
     * Constructor for InteractWithPlayerEvent.
     * @param object the {@link GameObject} to give to {@link Player}
     * @param dialog the message to display 
     */
    public InteractWithPlayerEvent(final GameObject object, final String dialog) {
        this(object, dialog, null, "");
    }

    /**
     * Constructor for InteractWithPlayerEvent with requirement.
     * @param object the {@link GameObject} to give to {@link Player}
     * @param dialog the message to display 
     * @param requirement the {@link GameObject} required to launch the main event
     * @param alterantiveDialog the message to display if the requirement is not respected
     */
    public InteractWithPlayerEvent(final GameObject object, final String dialog, final GameObject requirement,
            final String alterantiveDialog) {
        this.object = object;
        this.dialog = dialog;
        this.requirement = requirement == null ? Optional.empty() : Optional.of(requirement);
        this.alternativeDialog = alterantiveDialog;
        this.isAlreadyLunch = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void launch(GameState state) {
        if (!state.getState().equals(ApplicationState.GAME_DIALOG)) {
            state.setState(ApplicationState.GAME_DIALOG);
        }
        if (this.requirement.isPresent()) {
            if (state.getWorld().getPlayer().getBackPack().contains(this.requirement.get())) {
                launchMainEvent(state);
            } else {
                state.addDialog(this.alternativeDialog);
            }
        } else {
            launchMainEvent(state);
        }
    }

    private void launchMainEvent(final GameState state) {
        this.isAlreadyLunch = true;
        state.addDialog(this.dialog);
        state.getWorld().getPlayer().getBackPack().add(this.object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlreadyLunch() {
        return this.isAlreadyLunch;
    }

}
