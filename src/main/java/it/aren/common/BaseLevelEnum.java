package it.aren.common;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;
import it.aren.file.SettingsLoader;

public enum BaseLevelEnum {
    ONE("one", "level-one.png"),
    TWO("two", "level-two.png"),
    THREE("three", "level-three.png"),
    FOUR("four", "level-four.png");

    private BufferedImage image;
    private String level;

    BaseLevelEnum(final String level, final String levelTexture) {
        this.image = ImageLoader.loadImage(levelTexture, SettingsLoader.loadSettings().scale());
        this.level = level;
    }


    public BufferedImage getImage() {
        return image;
    }


    public String getLevel() {
        return level;
    }

}
