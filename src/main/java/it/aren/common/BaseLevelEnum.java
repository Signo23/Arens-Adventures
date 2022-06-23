package it.aren.common;

import java.awt.image.BufferedImage;
import java.util.List;

import it.aren.file.ImageLoader;
import it.aren.file.MapsLoader;
import it.aren.file.SettingsLoader;

public enum BaseLevelEnum {
    ONE("one", "level-one.png"),
    TWO("two", "level-two.png"),
    THREE("three", "level-three.png"),
    FOUR("four", "level-four.png");

    private BufferedImage image;
    private List<PointRange> points;

    BaseLevelEnum(final String level, final String levelTexture) {
        this.image = ImageLoader.loadImage(levelTexture, SettingsLoader.loadSettings().scale());
        points = MapsLoader.loadMaps("maps.json").get(level);
    }


    public BufferedImage getImage() {
        return image;
    }

    /**
     * Returns the {@link List} of {@link PointRange} of the {@link GameMap}'s blocks.
     * @return points a {@link List} of {@link PointRange}
     */
    public List<PointRange> getPoints() {
        return points;
    }
}
