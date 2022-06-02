package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;

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
        final ImageLoader il = new ImageLoader();
        this.texture = il.loadFile(image);
    }
}
