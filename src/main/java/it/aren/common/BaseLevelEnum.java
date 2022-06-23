package it.aren.common;

import java.awt.image.BufferedImage;
import java.util.List;

import it.aren.file.ImageLoader;
import it.aren.file.MapsLoader;
import it.aren.file.SettingsLoader;


/**
* An enum that is used to store the different levels of the game.
*/
public enum BaseLevelEnum {
    /**
     * Level one of the game.
     */
    ONE("one", "level-one.png"),
    /**
     * Level two of the game.
     */
    TWO("two", "level-two.png"),
    /**
     * Level three of the game.
     */
    THREE("three", "level-three.png"),
    /**
     * Level four of the game.
     */
    FOUR("four", "level-four.png");

    private BufferedImage image;
    private List<PointRange> points;

    BaseLevelEnum(final String level, final String levelTexture) {
        this.image = ImageLoader.loadImage(levelTexture, SettingsLoader.loadSettings().scale());
        points = MapsLoader.loadMaps("maps.json").get(level);
    }

    /**
     * Get the texture of level.
     * @return a {@link BufferedImage} containing the texture
     */
    public BufferedImage getImage() {
        return image;
    }

    public List<PointRange> getPoints() {
        return points;
    }


    public void setPoints(final List<PointRange> points) {
        this.points = points;
    }

}
