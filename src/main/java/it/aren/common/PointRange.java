package it.aren.common;

/**
 * A range delimited by two {@link Point2D}.
 *
 */
public class PointRange {

    private Point2D start;
    private Point2D end;

    /**
     * Constructor for {@link PointRange}.
     * @param start the starting {@link Point2D}
     * @param end the ending {@link Point2D}
     */
    public PointRange(final Point2D start, final Point2D end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Get the {@link Point2D} start of the range.
     * @return start
     */
    public final Point2D getStart() {
        return this.start;
    }

    /**
     * Set the {@link Point2D} start of the range.
     * @param start
     */
    public final void setStart(final Point2D start) {
        this.start = start;
    }

    /**
     * Get the {@link Point2D} end of the range.
     * @return end
     */
    public final Point2D getEnd() {
        return this.end;
    }

    /**
     * Set the {@link Point2D} end of the range.
     * @param end
     */
    public final void setEnd(final Point2D end) {
        this.end = end;
    }
}
