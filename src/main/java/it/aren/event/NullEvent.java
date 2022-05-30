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

    @Override
    /**
     * {@inheritDoc}
     */
    public void launch(final GameState state) {
    }

}
