package it.aren.input;

import it.aren.common.Direction;
import it.aren.model.BaseEntity;

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
