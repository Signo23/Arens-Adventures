package it.aren.graphic.game;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import it.aren.common.BaseObjectEnum;
import it.aren.common.Constant;
import it.aren.common.Direction;
import it.aren.file.SettingsLoader;

/**
 * Contain the {@link BufferedImage}s for {@link it.aren.model.Player} animation.
 */
public class PlayerAnimation {
    private final Map<Direction, LinkedList<BufferedImage>> idleSprite;
    private final Map<Direction, LinkedList<BufferedImage>> walkSprite;
    private long time;
    private final int spriteDimension;
    private static final  long ELAPSE = 250;

    /**
     * Main constructor.
     * Load all the sprite.
     */
    public PlayerAnimation() {
        this.idleSprite = new HashMap<>();
        this.walkSprite = new HashMap<>();
        this.spriteDimension = SettingsLoader.loadSettings().scale() * Constant.DEFAULT_HITBOX_DIMENSION;

        this.idleSprite.put(Direction.UP, new LinkedList<>());
        this.idleSprite.put(Direction.DOWN, new LinkedList<>());
        this.idleSprite.put(Direction.LEFT, new LinkedList<>());
        this.idleSprite.put(Direction.RIGHT, new LinkedList<>());

        this.walkSprite.put(Direction.UP, new LinkedList<>());
        this.walkSprite.put(Direction.DOWN, new LinkedList<>());
        this.walkSprite.put(Direction.LEFT, new LinkedList<>());
        this.walkSprite.put(Direction.RIGHT, new LinkedList<>());

        final BufferedImage idle = BaseObjectEnum.PLAYER_IDLE.getTexture();
        final BufferedImage walk = BaseObjectEnum.PLAYER_WALK.getTexture();
        for (int i = 0; i < 4; i++)  {
            for (int j = 0; j < 4; j++)  {
                switch (i) {
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
        this.time = System.currentTimeMillis();
    }

    private BufferedImage crop(final BufferedImage spriteSheet, final int x, final int y) {
        return spriteSheet.getSubimage(x * this.spriteDimension,
                y * this.spriteDimension, this.spriteDimension, this.spriteDimension);
    }

    /**
     * Get the next sprite of the idle's animation.
     * @param lastDirection {@link Direction} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextIdle(final Direction lastDirection) {
        if (PlayerAnimation.ELAPSE > System.currentTimeMillis() - time) {
            return this.idleSprite.get(lastDirection).peek();
        }
        final BufferedImage tmpImage = this.idleSprite.get(lastDirection).poll();
        this.idleSprite.get(lastDirection).add(tmpImage);
        time = System.currentTimeMillis();
        return tmpImage;
    }

    /**
     * Get the next sprite of the walk's animation.
     * @param direction {@link Direction} that indicate direction of animation
     * @return sprite's {@link BufferedImage}
     */
    public BufferedImage getNextWalk(final Direction direction) {
        if (PlayerAnimation.ELAPSE > System.currentTimeMillis() - time) {
            return this.walkSprite.get(direction).peek();
        }
        final BufferedImage tmpImage = this.walkSprite.get(direction).poll();
        this.walkSprite.get(direction).add(tmpImage);
        time = System.currentTimeMillis();
        return tmpImage;
    }
}
