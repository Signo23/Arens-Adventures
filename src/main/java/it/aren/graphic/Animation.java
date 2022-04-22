package it.aren.graphic;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import it.aren.common.Direction;
import it.aren.common.Point2D;
import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * Contain the {@link BufferedImage} for animation.
 */
public class Animation {
    Map<Direction, LinkedList<BufferedImage>> idleSprite;
    Map<Direction, LinkedList<BufferedImage>> walkSprite;

    /**
     * Main constructor.
     * Load all the sprite.
     */
    public Animation(final Entity ent) {
        this.idleSprite = new HashMap<>();
        this.walkSprite = new HashMap<>();
        //TODO load texture
        if(ent.getClass().equals(Player.class)) {
            //TODO load texture for player
        } //TODO load block's textures
    }

    /**
     * Get the next sprite of the idle's animation.
     * @param lastDirection {@link Point2D} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextIdle(final Direction lastDirection) {
        return this.idleSprite.get(lastDirection).peek();
    }

    /**
     * Get the next sprite of the walk's animation.
     * @param direction {@link Point2D} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextWalk(final Direction direction) {
        return this.walkSprite.get(direction).peek();
    }
}
