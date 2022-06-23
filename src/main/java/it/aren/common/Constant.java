/**
 * 
 */
package it.aren.common;

import java.awt.Dimension;

/**
 * Contains the game constant.
 *
 */
public class Constant {
    /**
     * Default dimension of the map in hit box.
     */
    public final static int DEFAULT_MAP_WIDTH = 16;
    public final static int DEAFULT_MAP_HEIGHT = 12;
    public static final int DEFAULT_MAP_DIMENSION = 16;
    /**
     * Default dimension of hit box.
     */
    public static final int DEFAULT_HITBOX_DIMENSION = 32;
    /**
     * Default FPS.
     */
    public static final long DEFAULT_FPS = 16; // 33 =~ 30 frames per second
    /**
     * Default screen dimension.
     */
    public static final Dimension DEFAULT_SCREEN_DIMENSION  = new Dimension(
            DEFAULT_MAP_WIDTH * DEFAULT_HITBOX_DIMENSION, DEAFULT_MAP_HEIGHT * DEFAULT_HITBOX_DIMENSION);
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
    public static final String FONT_FOLDER = "/assets/fonts/";
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
    public static final int DEFAULT_DIALOG_SIZE = 14;
    /**
     * Default ratio.
     */
    public static final int DEFAULT_RATIO = 1;
}