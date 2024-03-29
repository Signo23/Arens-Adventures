package it.aren.geom;

import it.aren.Vector;

import java.util.Objects;
/**
 * A point in 2 dimension.
 */
public class Vector2D implements Vector {

    private float x;
    private float y;

    /**
     * Create a point on the origin.
     */
    public Vector2D() {
        this(0, 0);
    }

    /**
     * Create a point on x, y coordinates.
     * @param x coordinate
     * @param y coordinate
     */
    public Vector2D(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public void setX(final float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public void setY(final float y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    /**
     * {@inheritDoc}
     */
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
        final Vector2D other = (Vector2D) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(other.x)
                && Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y);
    }

    @Override
    public Vector sum(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    @Override
    public Vector sum(Vector vectorToSum){
        return sum(vectorToSum.getX(), vectorToSum.getY());
    }

    @Override
    public Vector mul(float value){
        x *= value;
        y *= value;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return "Point2D [x=" + this.x + ", y=" + this.y + "]";
    }
}
