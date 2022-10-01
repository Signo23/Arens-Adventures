package it.aren.common;

/**
 * A range delimited by two {@link Vector2D}.
 *
 */
public class PointRange {

    private Vector start;
    private Vector end;

    /**
     * Constructor for {@link PointRange}.
     * @param start the starting {@link Vector2D}
     * @param end the ending {@link Vector2D}
     */
    public PointRange(final Vector start, final Vector end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Get the {@link Vector2D} start of the range.
     * @return start
     */
    public final Vector getStart() {
        return this.start;
    }

    /**
     * Set the {@link Vector2D} start of the range.
     * @param start
     */
    public final void setStart(final Vector start) {
        this.start = start;
    }

    /**
     * Get the {@link Vector2D} end of the range.
     * @return end
     */
    public final Vector getEnd() {
        return this.end;
    }

    /**
     * Set the {@link Vector2D} end of the range.
     * @param end
     */
    public final void setEnd(final Vector end) {
        this.end = end;
    }
}
