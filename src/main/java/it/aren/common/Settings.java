package it.aren.common;

import java.awt.Dimension;
/**
 * Manage settings of the game.
 */
public class Settings {
    private boolean antialiasingOn;
    private boolean renderQuality;
    private Dimension screenSize;
    
    /**
     * Load default settings from {@link Constant}
     */
    public Settings() {
        this.antialiasingOn = false;
        this.renderQuality = false;
        this.screenSize = Constant.DEFAULT_SCREEN_DIMENSION;
    }

    /**
     * Calculate the dimension of hitbox.
     * @return hitbox's {@link Dimension}
     */
    public Dimension hitboxDimension() {
        final int hitbox = this.screenSize.height / Constant.DEAFULT_MAP_HEIGHT;
        return new Dimension(hitbox, hitbox);
    }
    
    /**
     * Calculate the scale for correct sprite load.
     * @return the correct scale for sprite
     */
    public int spriteScale() {
        return this.hitboxDimension().height / Constant.DEFAULT_HITBOX_DIMENSION;
    }
    
    /**
     * Get the status for antialiasing's setting
     * @return the antialiasingOn
     */
    public boolean isAntialiasingOn() {
        return antialiasingOn;
    }

    /**
     * Set the antialiasing.
     * @param antialiasingOn the antialiasingOn to set
     */
    public void setAntialiasingOn(final boolean antialiasingOn) {
        this.antialiasingOn = antialiasingOn;
    }

    /**
     * Get the screen {@link Dimension}
     * @return the screenSize
     */
    public Dimension getScreenSize() {
        return screenSize;
    }

    /**
     * Set the screen {@link Dimension}
     * @param screenSize the screenSize to set
     */
    public void setScreenSize(final Dimension screenSize) {
        this.screenSize = screenSize;
    }

    /**
     * Get the status of quality of rendering.
     * @return the renderQuality
     */
    public boolean isRenderQuality() {
        return renderQuality;
    }

    /**
     * Get the status of quality of rendering.
     * @param renderQuality the renderQuality to set
     */
    public void setRenderQuality(final boolean renderQuality) {
        this.renderQuality = renderQuality;
    }
    
}
