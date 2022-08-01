package it.aren.model;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.file.SettingsLoader;
import it.aren.graphic.Component;
import it.aren.graphic.GraphicController;
/**
 * The main model of the game.
 *
 */
public class BaseEntity {
    private Point2D position;
    private boolean drawable;
    private Rectangle hitBox;
    private Map<String, Component> components;

    /**
     * Create an Entity.
     * @param position where position have to be set
     * @param drawable set if the block will be drawn
     * @param graphic for render the block
     */
    protected BaseEntity(final Point2D position, final boolean drawable, final Component graphic) {
        final int size = SettingsLoader.loadSettings().scale();
        this.position = position;
        this.drawable = drawable;
        this.components = new HashMap<>();
        this.components.put("graphic", graphic);
        this.hitBox = new Rectangle(size * Constant.DEFAULT_HITBOX_DIMENSION, size * Constant.DEFAULT_HITBOX_DIMENSION);
        this.hitBox.setLocation((int) this.position.getX(), (int) this.position.getY());
    }

    /**
     * Get Entity's position.
     * @return the position
     */
    public Point2D getPosition() {
        return this.position;
    }
    /**
     * Set Entity's position.
     * @param position the position to set
     */
    public void setPosition(final Point2D position) {
        this.position = position;
        this.hitBox.setLocation((int) position.getX(), (int) position.getY());
    }
    /**
     * Get if Entity is drawable.
     * @return the drawable
     */
    public boolean isDrawable() {
        return this.drawable;
    }
    /**
     * Set if Entity is drawable.
     * @param drawable the drawable to set
     */
    public void setDrawable(final boolean drawable) {
        this.drawable = drawable;
    }
    /**
     * Get Entity's {@link Component}.
     * @return the graphic
     */
    public Map<String, Component> getComponents() {
        return this.components;
    }
    /**
     * Set Entity's {@link Component}.
     * @param components the graphic to set
     */
    public void setComponents(final Map<String, Component> components) {
        this.components = components;
    }
    /**
     * Get Entity's {@link Rectangle} for hitBox.
     * @return the hitBox
     */
    public Rectangle getHitBox() {
        return hitBox;
    }
    /**
     * Set Entity's {@link Rectangle} for hitBox.
     * @param hitBox the Rectangle to set
     */
    public void setHitBox(final Rectangle hitBox) {
        this.hitBox = hitBox;
    }
    /**
     * Update the Entity's {@link Component}.
     * @param g {@link GraphicController} that update the entity
     */
    public void updateGraphic(final GraphicController g) {
        if (this.isDrawable()) {
            this.components.get("graphic").update(this, g);
        }
    }

}
