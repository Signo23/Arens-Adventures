package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

/**
 * Type that could be used for every type of Object.
 *
 */
public enum BaseObjectEnum {

    /**
     * Chest type.
     */
    CHEST("chest.png"),
    /**
     * Sign type.
     */
    SIGN("sign.png"),
    /**
     * NPC type.
     */
    NPC("npc.png"),
    /**
     * Box type.
     */
    BOX("box.png"),
    /**
     * Potion type.
     */
    POTION("potion.png"),
    /**
     * Jacket type.
     */
    JACKET("jacket.png"),
    /**
     * Key type.
     */
    KEY("key.png"),
    /**
     * Sword type.
     */
    SWORD("sword.png"),
    /**
     * Void type.
     */
    VOID(),
    /**
     * Player idle type.
     */
    PLAYER_IDLE("player-idle.png"),
    /**
     * Player walk type.
     */
    PLAYER_WALK("player-walk.png"),
    /**
     * Background type.
     */
    BACKGROUND("banner.png"),
    /**
     * Icon type.
     */
    ICON("icon.png");

    private final BufferedImage texture;

    BaseObjectEnum(final String image) {
        this.texture = ImageLoader.loadImage(image, SettingsLoader.loadSettings().scale());
    }

    BaseObjectEnum() {
        this.texture = new BufferedImage(1, 1, 1);
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
