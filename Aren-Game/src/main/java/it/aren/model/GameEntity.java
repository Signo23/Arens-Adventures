package it.aren.model;

import java.util.HashMap;
import java.util.Map;

import it.aren.common.Constant;

import it.aren.file.SettingsLoader;
import it.aren.model.game.GameHitBox;

/**
 * The main model of the game.
 *
 */
public class GameEntity implements Entity {
    private boolean drawable;
    private HitBox hitBox;
    private final Map<String, Component> components;

    private Direction velocity;

    /**
     * Create an Entity.
     * @param position where position have to be set
     * @param drawable set if the block will be drawn
     * @param graphic for render the block
     */
    protected GameEntity(final Vector position, final boolean drawable) {
        final SettingsLoader settingsLoader = new SettingsLoader();
        final int size = settingsLoader.loadFile(Constant.SETTINGS_FILE).scale();
        this.drawable = drawable;
        this.components = new HashMap<>();
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
    public void addComponent(String code, Component component) {
        this.components.put(code, component);
    }

    @Override
    public Component component(String code) {
        return this.components.getOrDefault(code, null);
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
    public <T> void update(String componentName, Controller<T> componentController) {
        if(this.components.containsKey(componentName)){
            this.components.get(componentName).update(this, componentController);
        }

    }

    @Override
    public void setVelocity(Direction direction) {
        this.velocity = direction;
    }

    @Override
    public Direction getVelocity() {
        return this.velocity;
    }

}
