package it.aren.model.input;

import it.aren.Controller;

/**
 * The controller for the input.
 */
public abstract class InputController implements Controller<String, Boolean> {

    public static final String UP = "u";
    public static final String DOWN = "d";
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    public static final String NO_ACTION = "n";
    public static final String INTERACT = "i";

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean interact;

    public boolean getAction(String action){
        switch (action){
            case UP:
                return up;
            case DOWN:
                return down;
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case INTERACT:
                return interact;
            default:
                return false;
        }
    }
}
