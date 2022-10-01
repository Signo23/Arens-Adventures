package it.aren.common;

public interface Range<T extends Vector> {
    /**
     * Get the {@link Vector2D} start of the range.
     *
     * @return start
     */
    T getStart();

    /**
     * Set the {@link Vector2D} start of the range.
     *
     * @param start
     */
    void setStart(T start);

    /**
     * Get the {@link Vector2D} end of the range.
     *
     * @return end
     */
    T getEnd();

    /**
     * Set the {@link Vector2D} end of the range.
     *
     * @param end
     */
    void setEnd(T end);
}
