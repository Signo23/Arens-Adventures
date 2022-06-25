package it.aren.graphic.menu;

import java.awt.Dimension;

/**
 * Model for readable dimension.
 * Extends {@link Dimension} 
 *
 */
public class ReadableDimension extends Dimension {
    private static final long serialVersionUID = 1L;

    /**
     * Create a readable dimension.
     * @return i
     * @return j
     */
    public ReadableDimension(final int i, final int j) {
        super(i, j);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.width + " x " + this.height;
    }
}