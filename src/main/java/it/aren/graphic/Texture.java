package it.aren.graphic;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;

/**
 * A class containing all the {@link BufferedImage} for the game.
 *
 */
public class Texture {

    private final BufferedImage player;
    private final BufferedImage chest;
    private final BufferedImage levelOne;
    
    /**
     * Load all the texture using {@link ImageLoader}.
     */
    public Texture() {
        final ImageLoader il = new ImageLoader();
        this.player = il.loadFile("player.png");
        this.chest = il.loadFile("chest.png");
        this.levelOne = il.loadFile("level-one.png");
    }

    /**
     * Get {@link BufferedImage} for player.
     * @return {@link BufferedImage} of player
     */
    public BufferedImage getPlayer() {
        return this.player;
    }

    /**
     * Get {@link BufferedImage} for chest.
     * @return {@link BufferedImage} of chest
     */
    public BufferedImage getChest() {
        return chest;
    }

    /**
     * Get {@link BufferedImage} for first level.
     * @return {@link BufferedImage} of levelOne
     */
    public BufferedImage getLevelOne() {
        return levelOne;
    }
    
    
    
}
