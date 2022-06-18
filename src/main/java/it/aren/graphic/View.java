/**
 * 
 */
package it.aren.graphic;

import it.aren.common.ApplicationState;

/**
 * Represents the main view of the game.
 *
 */
public interface View {

    /**
     * Method to call for update the view.
     */
    void render();
    void changeState(ApplicationState newState);
}
