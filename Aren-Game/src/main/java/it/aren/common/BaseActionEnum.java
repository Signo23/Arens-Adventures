package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

/**
 * Type that could be used for every type of Action.
 */
public enum BaseActionEnum {
    /**
     * Play type.
     */
    PLAY("play.png"),
    /**
    * Settings type.
    */
    SETTINGS("settings.png"),
    /**
     * Check on type.
     */
    CHECK_ON("check-on.png"),
    /**
     * Check off type.
     */
    CHECK_OFF("check-off.png"),
    /**
     * Save type.
     */
    SAVE("save.png"),
    /**
     * Clear type.
     */
    CLEAR("clear.png");

    private final BufferedImage texture;

    BaseActionEnum(final String fileName) {
        final ImageLoader imageLoader = new ImageLoader();
        this.texture = imageLoader.loadFile(fileName);
    }

    /**
     * Get the texture linked to the type.
     * @return a {@link BufferedImage} representing the type's texture
     */
    public BufferedImage getTexture() {
        return texture;
    }
}