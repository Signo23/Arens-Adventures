package it.aren.graphic;

import java.awt.image.BufferedImage;

import it.aren.file.ImageLoader;

/**
 * A class containing all the {@link BufferedImage} for the game.
 *
 */
public class Texture {

    private final BufferedImage playerIdle;
    private final BufferedImage playerWalk;
    private final BufferedImage chest;
    private final BufferedImage levelOne;
    private final ImageLoader il = new ImageLoader();
    
    /**
     * 
     * Load all the texture using {@link ImageLoader}.
     */
    public Texture() {
        this.playerIdle = il.loadFile("player-idle.png");
        this.playerWalk = il.loadFile("player-walk.png");
        this.chest = il.loadFile("chest.png");
        this.levelOne = il.loadFile("level-one.png");
    }

    /**
     * Get {@link BufferedImage} for player.
     * @return {@link BufferedImage} of player
     */
    public BufferedImage getPlayerIdle() {
        return this.playerIdle;
    }

    public BufferedImage getPlayerWalk() {
        return this.playerWalk;
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
