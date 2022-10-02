package it.aren.model.input;

/**
 * The input controller for the keyboard.
 * Implements {@link InputController}
 */
public class KeyboardInputController extends InputController {

    @Override
    public void update(String action) {
        this.action = action;
    }
}
