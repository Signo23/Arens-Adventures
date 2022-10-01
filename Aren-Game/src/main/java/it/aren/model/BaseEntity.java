package it.aren.model;

import java.util.HashMap;
import java.util.Map;

import it.aren.common.Constant;
import it.aren.common.Vector2D;
import it.aren.graphic.Component;
import it.aren.graphic.GraphicController;
import it.aren.common.Vector;
import it.aren.file.SettingsLoader;
import it.aren.model.game.GameHitBox;

/**
 * The main model of the game.
 *
 */
public class BaseEntity {
    private boolean drawable;
    private HitBox hitBox;
    private Map<String, Component> components;

    private Vector velocity;

    /**
     * Create an Entity.
     * @param position where position have to be set
     * @param drawable set if the block will be drawn
     * @param graphic for render the block
     */
    protected BaseEntity(final Vector position, final boolean drawable, final Component graphic) {
        final int size = SettingsLoader.loadSettings().scale();
        this.drawable = drawable;
        this.components = new HashMap<>();
        this.components.put("graphic", graphic);
        this.hitBox = new GameHitBox(position, new Vector2D(size * Constant.DEFAULT_HITBOX_DIMENSION,
                size * Constant.DEFAULT_HITBOX_DIMENSION));
    }

    /**
     * Get Entity's position.
     * @return the position
     */
    public Vector getPosition() {
        return this.hitBox.position();
    }
    /**
     * Set Entity's position.
     * @param position the position to set
     */
    public void setPosition(final Vector position) {
        this.hitBox.position().setX(position.getX());
        this.hitBox.position().setY(position.getY());
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
     * Get Entity's {@link HitBox} for hitBox.
     * @return the hitBox
     */
    public HitBox getHitBox() {
        return hitBox;
    }
    /**
     * Set Entity's {@link HitBox} for hitBox.
     * @param hitBox the Rectangle to set
     */
    public void setHitBox(final HitBox hitBox) {
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
