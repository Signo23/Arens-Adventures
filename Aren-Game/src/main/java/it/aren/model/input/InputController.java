package it.aren.model.input;

import it.aren.Controller;

/**
 * The controller for the input.
 */
public abstract class InputController implements Controller<String> {

    protected String action = "";
    public static final String UP = "u";
    public static final String DOWN = "d";
    public static final String LEFT = "l";
    public static final String RIGHT = "r";
    public static final String NO_ACTION = "n";
    public static final String INTERACT = "i";
    public static final String ON_CLOSE_DIALOG = "c";

    public String getAction(){
        return this.action;
    }
}
