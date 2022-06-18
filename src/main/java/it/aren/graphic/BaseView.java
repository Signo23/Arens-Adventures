/**
 * 
 */
package it.aren.graphic;

import it.aren.common.ApplicationState;

/**
 * Represents the main view of the game.
 *
 */
public interface BaseView {

    /**
     * Method to call for update the view.
     */
    void render();

    /**
     * Change the view's state.
     * @param newState the {@link ApplicationState} to pass to
     */
    void changeState(ApplicationState newState);
}
