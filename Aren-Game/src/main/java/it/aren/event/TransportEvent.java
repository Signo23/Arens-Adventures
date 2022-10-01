package it.aren.event;

import it.aren.common.Vector2D;
import it.aren.model.GameState;
import it.aren.model.Vector;

/**
 * A class for switch from one {@link GameMap} to another.
 * Implements {@link BaseEvent}
 *
 */
public class TransportEvent implements BaseEvent {

    private final Vector position;
    private final int level;

    /**
     * Constructor for TransportEvent.
     * @param position the {@link Vector2D} for place the {@link Player} in the next {@link GameMap}
     * @param level the index of the next {@link GameMap}
     */
    public TransportEvent(final Vector position, final int level) {
        this.position = position;
        this.level = level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void launch(final GameState state) {
        state.getWorld().setCurrentMap(this.level);
        state.getWorld().getPlayer().setPosition(this.position);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final boolean isAlreadyLunch() {
        return true;
    }

}
