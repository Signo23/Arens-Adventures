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
    ICON("icon.png"),
    /**
     * Second NPC type.
     */
    NPC_2("npc-2.png");

    private final BufferedImage texture;

    BaseObjectEnum(final String image) {
        final ImageLoader imageLoader = new ImageLoader();
        this.texture = imageLoader.loadFile(image);
    }

    BaseObjectEnum() {
        this.texture = new BufferedImage(1, 1, 1);
    }

    /**
     * Get the texture linked to the type.
     * @return a {@link BufferedImage} representing the type's texture
     */
    public BufferedImage getTexture() {
        return texture;
    }
}
