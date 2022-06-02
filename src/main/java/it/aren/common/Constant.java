/**
 * 
 */
package it.aren.common;

/**
 * Contains the game constant.
 *
 */
public class Constant {
    /**
     * Default dimension of the map in hitbox.
     */
    public static final int DEFAULT_MAP_DIMENSION = 16;
    /**
     * Default dimension of hitbox.
     */
    public static final int DEFAULT_HITBOX_DIMENSION = 32;
    /**
     * Default FPS.
     */
    public static final long DEFAULT_FPS = 16; // 33 =~ 30 frames per second
    /**
     * User's home directory.
     */
    public static final String HOME = System.getProperty("user.home");
    /**
     * System's separator.
     */
    public static final String SEP = System.getProperty("file.separator");
    /**
     * Game's main directory.
     */
    public static final String MAIN_FOLDER = HOME +  SEP + ".aren";
    /**
     * Game's textures directory.
     */
    public static final String TEXTURES_FOLDER = "/assets/textures/";
    /**
     * Game's font directory.
     */
    public static final String FONT_FOLDER = "/assets/fonts";
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for left
     */
    public static final Point2D LEFT = new Point2D(-1, 0);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for right
     */
    public static final Point2D RIGHT = new Point2D(1, 0);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for up
     */
    public static final Point2D UP = new Point2D(0, -1);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for down
     */
    public static final Point2D DOWN = new Point2D(0, 1);
    /**
     * Default velocity.
     */
    public static final int DEFAULT_VEL = 2;

    /**
     * Default Dialog position.
     */
    public static final Point2D DEFAULT_DIALOG_POSITION = new Point2D(1 * DEFAULT_HITBOX_DIMENSION, 8 * DEFAULT_HITBOX_DIMENSION);

    /**
     * Default Text dimension.
     */
    public static final int DEFAULT_TEXT_DIMENSION = 20;

    /**
     * Default Dialog size.
     */
    public static final int DEFAULT_DIALOG_SIZE = 14 * DEFAULT_HITBOX_DIMENSION;

    /**
     * Default ratio.
     */
    public static final int DEFAULT_RATIO = 1;
}
