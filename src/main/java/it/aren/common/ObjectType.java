package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

public enum ObjectType {
    CHEST("chest.png"),
    SIGN("sign.png"),
    NPC("npc.png"),
    BOX("box.png"),
    POTION("potion.png"),
    JACKET("jacket.png"),
    KEY("key.png"),
    SWORD("sword.png"),
    VOID("");
    
    public final BufferedImage texture;
    
    ObjectType(final String image){
        this.texture = image.equals("") ? new BufferedImage(1, 1, 1) : ImageLoader.loadImage(image, SettingsLoader.loadSettings().scale());
        System.out.println(image);
    }
}
