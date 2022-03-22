/**
 * 
 */
package it.aren.common;

import java.util.Objects;

public class Point2D {

    private double x;
    private double y;

    
    public Point2D() {
        this(0,0);
    }
    
    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(final double y) {
        this.y = y;
    }


    @Override
    public final int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point2D)) {
            return false;
        }
        final Point2D other = (Point2D) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
                && Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }

    @Override
    public final String toString() {
        return "Point2D [x=" + x + ", y=" + y + "]";
    }
}
