package it.aren.common;

/**
 * Direction's vectors.
 */
public enum Direction {
    /**
     * The {@link Point2D} for left.
     */
    LEFT(-1, 0),
    /**
     * The {@link Point2D} for right.
     */
    RIGHT(1, 0),
    /**
     * The {@link Point2D} for up.
     */
    UP(0, -1),
    /**
     * The {@link Point2D} for down.
     */
    DOWN(0, 1);

    private final Point2D vector;

    Direction(final int x, final int y) {
        this.vector = new Point2D(x, y);
    }

    /**
     * Get the vector of direction.
     * @return a {@link Point2D} representing the vector
     */
    public Point2D getVector() {
        return this.vector;
    }

    /**
     * Returns the enum constant of this type with the most similar point.
     * @param point the {@link Point2D} of the enum constant to be returned.
     * @return the enum constant with the similar point
     */
    public static Direction valueOfPoint2D(final Point2D point) {
        final int x = (int) point.getX();
        final int y = (int) point.getY();
        final int xAbs = Math.abs(x);
        final int yAbs = Math.abs(y);
        return xAbs > yAbs ? x > 0 ? RIGHT : LEFT : y > 0 ? DOWN : UP;
    }
}
