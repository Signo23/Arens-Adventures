package it.aren.model;

/**
 * Direction's vectors.
 */
public enum Direction {
    /**
     * The {@link Vector2D} for left.
     */
    LEFT(-1, 0),
    /**
     * The {@link Vector2D} for right.
     */
    RIGHT(1, 0),
    /**
     * The {@link Vector2D} for up.
     */
    UP(0, -1),
    /**
     * The {@link Vector2D} for down.
     */
    DOWN(0, 1),
    NO_DIRECTION(0,0);

    private final Vector vector;

    Direction(final int x, final int y) {
        this.vector = new Vector2D(x, y);
    }

    /**
     * Get the vector of direction.
     * @return a {@link Vector2D} representing the vector
     */
    public Vector getVector() {
        return this.vector;
    }

    /**
     * Returns the enum constant of this type with the most similar point.
     * @param point the {@link Vector2D} of the enum constant to be returned.
     * @return the enum constant with the similar point
     */
    public static Direction valueOfPoint2D(final Vector point) {
        final int x = (int) point.getX();
        final int y = (int) point.getY();
        final int xAbs = Math.abs(x);
        final int yAbs = Math.abs(y);
        return xAbs == yAbs ? NO_DIRECTION : xAbs > yAbs ? x > 0 ? RIGHT : LEFT : y > 0 ? DOWN : UP;
    }
}
