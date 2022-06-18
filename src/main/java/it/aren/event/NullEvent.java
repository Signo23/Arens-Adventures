/**
 * 
 */
package it.aren.event;

import it.aren.model.GameState;

/**
 * A class that don't do nothing.
 * Implements {@link Event}
 *
 */
public class NullEvent implements Event {

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
