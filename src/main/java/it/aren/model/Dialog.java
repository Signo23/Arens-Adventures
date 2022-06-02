package it.aren.model;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;

public class Dialog extends Entity {

    private String text;
    private boolean scroll;
    public Dialog(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final int size, final String text) {
        super(position, drawable, graphic, input, size);
        this.setText(text);
        this.setScroll(false);
    }

    @Override
    public final void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    @Override
    public final void updateInput(final InputController i) {
        this.input.update(this, i);
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public boolean isScroll() {
        return scroll;
    }

    public void setScroll(boolean scroll) {
        this.scroll = scroll;
    }

}
