/**
 * 
 */
package it.aren.common;

import java.util.Objects;

public class Point2D {

    private float x;
    private float y;

    
    public Point2D() {
        this(0,0);
    }
    
    public Point2D(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(final float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(final float y) {
        this.y = y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
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
        return Float.floatToIntBits(x) == Float.floatToIntBits(other.x)
                && Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
    }

    @Override
    public final String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }
}
