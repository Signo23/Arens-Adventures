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
    
    /**
     * 
     * Load all the texture using {@link ImageLoader}.
     */
    public Texture(final int ratio) {
        this.playerIdle = ImageLoader.loadImage("player-idle.png", ratio);
        this.playerWalk = ImageLoader.loadImage("player-walk.png", ratio);
        this.chest = ImageLoader.loadImage("chest.png", ratio);
        this.levelOne = ImageLoader.loadImage("level-one.png", ratio);
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
