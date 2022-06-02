package it.aren.model;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;

public class Dialog extends BaseEntity {

    private String text;
    public Dialog(final Point2D position, final boolean drawable, final GraphicComponent graphic, final int size, final String text) {
        super(position, drawable, graphic, size);
        this.setText(text);
    }
    /**
     * Return the dialog's text.
     * @return text
     */
    public final String getText() {
        return text;
    }
    /**
     * Set the dialog's text.
     * @param text
     */
    public final void setText(final String text) {
        this.text = text;
    }
}
