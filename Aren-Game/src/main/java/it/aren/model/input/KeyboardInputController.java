package it.aren.model.input;

/**
 * The input controller for the keyboard.
 * Implements {@link InputController}
 */
public class KeyboardInputController extends InputController {

    @Override
    public void update(String action, Boolean value) {
        switch (action){
            case UP:
                up = value;
                break;
            case DOWN:
                down = value;
                break;
            case LEFT:
                left = value;
                break;
            case RIGHT:
                right = value;
                break;
            case INTERACT:
                interact = !interact;
                break;
            default:
                break;
        }
    }
}
