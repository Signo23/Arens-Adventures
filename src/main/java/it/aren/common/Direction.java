/**
 * 
 */
package it.aren.common;

/**
 * Direction's vectors.
 */
public enum Direction {
    /**
     * The {@link Point2D} for left
     */
    LEFT(-1, 0),
    /**
     * The {@link Point2D} for right
     */
    RIGHT(1, 0),
    /**
     * The {@link Point2D} for up
     */
    UP(0, -1),
    /**
     * The {@link Point2D} for down
     */
    DOWN(0, 1);
    
    public final Point2D vector;
    
    Direction(final int x, final int y) {
        this.vector = new Point2D(x, y);
    }
}
