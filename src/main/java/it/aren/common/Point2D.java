/**
 * 
 */
package it.aren.common;

import java.util.Objects;
/**
 * A point in 2 dimension.
 */
public class Point2D {

    private float x;
    private float y;

    /**
     * Create a point on the origin
     */
    public Point2D() {
        this(0,0);
    }
    
    /**
     * Create a point on x, y coordinates
     * @param x coordinate
     * @param y coordinate
     */
    public Point2D(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get Point2D's x.
     * @return the x
     */
    public float getX() {
        return this.x;
    }

    /**
     * Set Point2D's x.
     * @param x the x to set
     */
    public void setX(final float x) {
        this.x = x;
    }

    /**
     * Get Point2D's y.
     * @return the y
     */
    public float getY() {
        return this.y;
    }

    /**
     * Set Point2D's y.
     * @param y the y to set
     */
    public void setY(final float y) {
        this.y = y;
    }


    @Override
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(other.x)
                && Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public final String toString() {
        return "Point2D [x=" + this.x + ", y=" + this.y + "]";
    }
}
