/**
 * 
 */
package it.aren.input;

/**
 *
 *
 */
public class MenuInputController implements BaseMenuInputController {
    private boolean interact;
    private boolean settings;

    public MenuInputController() {
    this.interact = false;
    this.settings = false;
    }
    /**
    *
    */
    public void notifyIsInteract() {
    this.interact = true;
    }
    /**
    *
    */
    public void notifyNoMoreIsInteract() {
    this.interact = false;
    }
    /**
    *
    */
    public void notifyIsSettings() {
    this.settings = true;
    }
    /**
    *
    */
    public void notifyNoMoreIsSettings() {
    this.settings = false;
    }

    /**
    *
    */
    @Override
    public boolean isInteract() {
    return this.interact;
    }

    /**
    *
    */
    @Override
    public boolean isSettings() {
    return this.settings;
    }
}
