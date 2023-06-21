package it.aren.model.event;

import it.aren.model.GameState;

/**
 * A class that don't do nothing.
 * Implements {@link BaseEvent}
 *
 */
public class NullEvent implements BaseEvent {

    /**
     * {@inheritDoc}
     */
    @Override
    public void launch(final GameState state) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAlreadyLunch() {
        return true;
    }

}
