package it.aren.model.game;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.file.SettingsLoader;
import it.aren.graphic.GraphicComponent;
import it.aren.model.BaseEntity;

public class Dialog extends BaseEntity {

    private String text;
    public Dialog(final Point2D position, final boolean drawable, final GraphicComponent graphic, final String text) {
        super(position, drawable, graphic);
        this.setText(text);
        final int ratio = SettingsLoader.loadSettings().scale();
        this.getHitBox().setSize(14 * ratio * Constant.DEFAULT_HITBOX_DIMENSION, 3 * ratio * Constant.DEFAULT_HITBOX_DIMENSION);
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
