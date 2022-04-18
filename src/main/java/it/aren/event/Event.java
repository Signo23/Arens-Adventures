/**
 * 
 */
package it.aren.event;

import it.aren.model.World;

/**
 * Interface for create events that interact with {@link World}.
 */
public interface Event {
    /**
     * Launch the event.
     * @param world {@link World} to interact with
     */
    void launch(World world);
}
