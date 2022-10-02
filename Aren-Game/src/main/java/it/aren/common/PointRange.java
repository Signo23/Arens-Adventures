package it.aren.common;

import it.aren.model.Range;
import it.aren.model.Vector2D;

/**
 * A range delimited by two {@link Vector2D}.
 *
 */
public class PointRange implements Range<Vector2D> {

    private Vector2D start;
    private Vector2D end;

    /**
     * Constructor for {@link PointRange}.
     * @param start the starting {@link Vector2D}
     * @param end the ending {@link Vector2D}
     */
    public PointRange(final Vector2D start, final Vector2D end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public final Vector2D getStart() {
        return this.start;
    }

    @Override
    public final void setStart(final Vector2D start) {
        this.start = start;
    }

    @Override
    public final Vector2D getEnd() {
        return this.end;
    }

    @Override
    public final void setEnd(final Vector2D end) {
        this.end = end;
    }
}
