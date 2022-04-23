package it.aren.graphic;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import it.aren.common.Constant;
import it.aren.common.Direction;
import it.aren.common.Point2D;
import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * Contain the {@link BufferedImage}s for animation.
 */
public class Animation {
    private final Map<Direction, LinkedList<BufferedImage>> idleSprite;
    private final Map<Direction, LinkedList<BufferedImage>> walkSprite;
    private long time;
    private final static long ELAPSE = 250;

    /**
     * Main constructor.
     * Load all the sprite.
     */
    public Animation(final Class<? extends Entity> entClass, final Texture texture) {
        this.idleSprite = new HashMap<>();
        this.walkSprite = new HashMap<>();
        
        this.idleSprite.put(Direction.UP, new LinkedList<>());
        this.idleSprite.put(Direction.DOWN, new LinkedList<>());
        this.idleSprite.put(Direction.LEFT, new LinkedList<>());
        this.idleSprite.put(Direction.RIGHT, new LinkedList<>());
        
        this.walkSprite.put(Direction.UP, new LinkedList<>());
        this.walkSprite.put(Direction.DOWN, new LinkedList<>());
        this.walkSprite.put(Direction.LEFT, new LinkedList<>());
        this.walkSprite.put(Direction.RIGHT, new LinkedList<>());
        
        if(entClass.equals(Player.class)) {
            final BufferedImage idle = texture.getPlayerIdle();
            final BufferedImage walk = texture.getPlayerWalk();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    switch(i) {
                        case 0:
                            this.idleSprite.get(Direction.DOWN).add(crop(idle, j, i));
                            this.walkSprite.get(Direction.DOWN).add(crop(walk, j, i));
                            break;
                        case 1:
                            this.idleSprite.get(Direction.LEFT).add(crop(idle, j, i));
                            this.walkSprite.get(Direction.LEFT).add(crop(walk, j, i));
                            break;
                        case 2:
                            this.idleSprite.get(Direction.RIGHT).add(crop(idle, j, i));
                            this.walkSprite.get(Direction.RIGHT).add(crop(walk, j, i));
                            break;
                        case 3:
                            this.idleSprite.get(Direction.UP).add(crop(idle, j, i));
                            this.walkSprite.get(Direction.UP).add(crop(walk, j, i));
                            break;
                        default:
                            break;
                    }
                }
            }
            
        } //TODO load block's textures
        this.time = System.currentTimeMillis();
    }

    private BufferedImage crop(final BufferedImage spriteSheet, final int x, final int y) {
        return spriteSheet.getSubimage(x * Constant.DEFAULT_HITBOX_DIMENSION,
                y*Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);
    }

    /**
     * Get the next sprite of the idle's animation.
     * @param lastDirection {@link Point2D} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextIdle(final Direction lastDirection) {
        if(Animation.ELAPSE > System.currentTimeMillis() - time) {
            return this.idleSprite.get(lastDirection).peek();
        }
        final BufferedImage tmpImage = this.idleSprite.get(lastDirection).poll();
        this.idleSprite.get(lastDirection).add(tmpImage);
        time = System.currentTimeMillis();
        return tmpImage;
    }

    /**
     * Get the next sprite of the walk's animation.
     * @param direction {@link Point2D} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextWalk(final Direction direction) {
        if(Animation.ELAPSE > System.currentTimeMillis() - time) {
            return this.walkSprite.get(direction).peek();
        }
        final BufferedImage tmpImage = this.walkSprite.get(direction).poll();
        this.walkSprite.get(direction).add(tmpImage);
        time = System.currentTimeMillis();
        return tmpImage;
    }
}
