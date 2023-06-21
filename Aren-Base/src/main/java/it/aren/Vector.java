package it.aren;

public interface Vector {
    /**
     * Get Point2D's x.
     *
     * @return the x
     */
    float getX();

    /**
     * Set Point2D's x.
     *
     * @param x the x to set
     */
    void setX(float x);

    /**
     * Get Point2D's y.
     *
     * @return the y
     */
    float getY();

    /**
     * Set Point2D's y.
     *
     * @param y the y to set
     */
    void setY(float y);

    Vector sum(float x, float y);
    Vector sum(Vector vectorToSum);
    Vector mul(float value);
}
