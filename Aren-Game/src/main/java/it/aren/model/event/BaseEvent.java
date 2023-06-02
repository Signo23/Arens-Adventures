package it.aren.model.event;

import it.aren.model.GameState;

/**
 * Interface for create events that interact with the game}.
 */
public interface BaseEvent {
    /**
     * Launch the event.
     * @param state {@link GameState} to interact with
     */
    void launch(GameState state);

    /**
     * Check if the event was already launched.
     * @return true if was launched, false otherwise
     */
    boolean isAlreadyLunch();
}
