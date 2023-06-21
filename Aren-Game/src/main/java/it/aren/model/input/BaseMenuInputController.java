package it.aren.model.input;

/**
 * The menu input controller interface to set interact with the game and settings.
 */
public interface BaseMenuInputController {
    /**
     * Boolean method for the interact with the game.
     */
    boolean isInteract();
    /**
     * Boolean method for settings.
     */
    boolean isSettings();
}
