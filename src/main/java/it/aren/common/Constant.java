/**
 * 
 */
package it.aren.common;

/**
 *
 *
 */
public class Constant {
    public final static int DEFAULT_MAP_DIMENSION = 16;
    public final static int DEFAULT_HITBOX_DIMENSION = 32;
    public static final long DEFAULT_FPS = 33; // =~ 30 frames per second
    public final static String HOME = System.getProperty("user.home");
    public final static String SEP = System.getProperty("file.separator");
    public final static String MAIN_FOLDER = HOME +  SEP + ".aren";
    public final static Point2D LEFT = new Point2D(-1, 0);
    public final static Point2D RIGHT = new Point2D(1, 0);
    public final static Point2D UP = new Point2D(0, -1);
    public final static Point2D DOWN = new Point2D(0, 1);
    public final static int DEFAULT_VEL = 10;
}
