package it.aren.common;

public class PointRange {

    private Point2D start;
    private Point2D end;

    public PointRange(final Point2D start, final Point2D end) {
        this.setStart(start);
        this.setEnd(end);
    }

    public final Point2D getStart() {
        return start;
    }

    public final void setStart(final Point2D start) {
        this.start = start;
    }

    public final Point2D getEnd() {
        return end;
    }

    public final void setEnd(final Point2D end) {
        this.end = end;
    }
}
