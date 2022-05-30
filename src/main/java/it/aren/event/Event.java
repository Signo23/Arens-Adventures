/**
 * 
 */
package it.aren.event;

import it.aren.model.GameState;
import it.aren.model.World;

/**
 * Interface for create events that interact with {@link World}.
 */
public interface Event {
    /**
     * Launch the event.
     * @param state {@link GameState} to interact with
     */
    void launch(GameState state);
}
