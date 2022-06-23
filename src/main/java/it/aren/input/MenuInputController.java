/**
 * 
 */
package it.aren.input;

/**
 * The input controller for the menu.
 * Implements {@link BaseMenuInputController}
 */
public class MenuInputController implements BaseMenuInputController {
    private boolean interact;
    private boolean settings;

    public MenuInputController() {
    this.interact = false;
    this.settings = false;
    }
    /**
     * Set notifyIsInteract to true.
     */
    public void notifyIsInteract() {
    this.interact = true;
    }
    /**
     * Set notifyNoMoreIsInteract to false.
     */
    public void notifyNoMoreIsInteract() {
    this.interact = false;
    }
    /**
     * Set notifyIsSettings to true.
     */
    public void notifyIsSettings() {
    this.settings = true;
    }
    /**
     * Set notifyNoMoreIsSettings to false.
     */
    public void notifyNoMoreIsSettings() {
    this.settings = false;
    }

    /**
     * Return isInteract. 
     * @return interact
     */
    public boolean isInteract() {
    return this.interact;
    }

    /**
     * Return isSettings. 
     * @return settings
     */
    public boolean isSettings() {
    return this.settings;
    }
}
