package it.aren.model;

import java.util.HashMap;
import java.util.Map;

import it.aren.common.Constant;
import it.aren.common.Vector2D;

import it.aren.graphic.GraphicController;
import it.aren.file.SettingsLoader;
import it.aren.model.game.GameHitBox;

/**
 * The main model of the game.
 *
 */
public class GameEntity implements BaseEntity {
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
    protected GameEntity(final Vector position, final boolean drawable, final Component graphic) {
        final int size = SettingsLoader.loadSettings().scale();
        this.drawable = drawable;
        this.components = new HashMap<>();
        this.components.put("graphic", graphic);
        this.hitBox = new GameHitBox(position, new Vector2D(size * Constant.DEFAULT_HITBOX_DIMENSION,
                size * Constant.DEFAULT_HITBOX_DIMENSION));
    }

    @Override
    public Vector getPosition() {
        return this.hitBox.position();
    }
    @Override
    public void setPosition(final Vector position) {
        this.hitBox.position().setX(position.getX());
        this.hitBox.position().setY(position.getY());
    }
    @Override
    public boolean isDrawable() {
        return this.drawable;
    }
    @Override
    public void setDrawable(final boolean drawable) {
        this.drawable = drawable;
    }
    @Override
    public Map<String, Component> getComponents() {
        return this.components;
    }
    @Override
    public void setComponents(final Map<String, Component> components) {
        this.components = components;
    }
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
    @Override
    public void setHitBox(final HitBox hitBox) {
        this.hitBox = hitBox;
    }

    @Override
    public void update(String componentName, Controller componentController) {

    }

    public void updateGraphic(final GraphicController g) {
        if (this.isDrawable()) {
            this.components.get("graphic").update(this, g);
        }
    }

}
