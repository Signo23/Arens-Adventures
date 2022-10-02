package it.aren.model.game;

import it.aren.common.Constant;
import it.aren.model.*;
import it.aren.file.SettingsLoader;

import java.util.Set;

/**
 * Model for the dialog.
 * Extends {@link GameEntity}
 *
 */
public class Dialog extends GameEntity {

    private String text;

    /**
     * Create a dialog.
     * @param position the {@link Vector2D} where the dialog is
     * @param drawable set if the dialog will be drawn
     * @param graphic the {@link GraphicCopmonent} for draw the dialog
     * @param text the message to display
     */
    public Dialog(final Vector position, final boolean drawable, final Component graphic, final String text) {
        super(position, drawable);
        this.setText(text);
        final SettingsLoader settingsLoader = new SettingsLoader();
        final int ratio = settingsLoader.loadFile(Constant.SETTINGS_FILE).scale();
        this.getHitBox().dimension().setX(14 * ratio * Constant.DEFAULT_HITBOX_DIMENSION);
        this.getHitBox().dimension().setY(3 * ratio * Constant.DEFAULT_HITBOX_DIMENSION);
        this.addComponent(GameComponent.GRAPHIC, graphic);
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
