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
    public final static int DEFAULT_MAP_DIMENSION = 16;
    /**
     * Default dimension of hitbox
     */
    public final static int DEFAULT_HITBOX_DIMENSION = 32;
    /**
     * Default FPS
     */
    public static final long DEFAULT_FPS = 16; // 33 =~ 30 frames per second
    /**
     * User's home directory
     */
    public final static String HOME = System.getProperty("user.home");
    /**
     * System's separator
     */
    public final static String SEP = System.getProperty("file.separator");
    /**
     * Game's main directory
     */
    public final static String MAIN_FOLDER = HOME +  SEP + ".aren";
    /**
     * Game's textures directory
     */
    public final static String TEXTURES_FOLDER = "/assets/textures/";
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for left
     */
    public final static Point2D LEFT = new Point2D(-1, 0);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for right
     */
    public final static Point2D RIGHT = new Point2D(1, 0);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for up
     */
    public final static Point2D UP = new Point2D(0, -1);
    /**
     * @deprecated use {@link Direction}
     * The {@link Point2D} for down
     */
    public final static Point2D DOWN = new Point2D(0, 1);
    /**
     * Default velocity
     */
    public final static int DEFAULT_VEL = 2;
    
    /**
     * Default Dialog position.
     */
    public final static Point2D DEFAULT_DIALOG_POSITION = new Point2D(160, 128);
    
    /**
     * Default Text dimension.
     */
    public final static int DEFAULT_TEXT_DIMENSION = 20;
    
    /**
     * Default Dialog size.
     */
    public final static int DEFAULT_DIALOG_SIZE = 160;
}
