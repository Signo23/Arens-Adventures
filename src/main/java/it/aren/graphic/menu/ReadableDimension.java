package it.aren.graphic.menu;

import java.awt.Dimension;

public class ReadableDimension extends Dimension {
    private static final long serialVersionUID = 1L;

    public ReadableDimension(final int i, final int j) {
        super(i, j);
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return this.width + " x " + this.height;
    }
}