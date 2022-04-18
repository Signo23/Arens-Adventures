/**
 * 
 */
package it.aren.event;

import it.aren.model.World;

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
    public void launch(final World world) {
    }

}
