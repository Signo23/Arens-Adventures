package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

public enum BaseObjectEnum {
    CHEST("chest.png"),
    SIGN("sign.png"),
    NPC("npc.png"),
    BOX("box.png"),
    POTION("potion.png"),
    JACKET("jacket.png"),
    KEY("key.png"),
    SWORD("sword.png"),
    VOID(),
    PLAYER_IDLE("player-idle.png"),
    PLAYER_WALK("player-walk.png");
    
    private final BufferedImage texture;
    
    BaseObjectEnum(final String image){
        this.texture = ImageLoader.loadImage(image, SettingsLoader.loadSettings().scale());
    }
    
    BaseObjectEnum(){
        this.texture = new BufferedImage(1, 1, 1);
    }

    public BufferedImage getTexture() {
        return texture;
    }
}
