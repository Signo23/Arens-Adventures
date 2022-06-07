package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

public enum BaseLevelEnum {
    ONE("level-one.png"),
    TWO("level-two.png"),
    THREE("level-three.png"),
    FOUR("level-four.png");
    
    private BufferedImage image;
    
    BaseLevelEnum(final String levelTexture){
        this.image = ImageLoader.loadImage(levelTexture, SettingsLoader.loadSettings().scale());
    }


    public BufferedImage getImage() {
        return image;
    }

}
