package it.aren.model;

import java.util.HashMap;
import java.util.Map;

import it.aren.*;
import it.aren.common.Constant;

import it.aren.core.GameFactory;
import it.aren.geom.Vector2D;
import it.aren.model.game.GameHitBox;

/**
 * The main model of the game.
 *
 */
public class GameEntity implements Entity {
    private boolean drawable;
    private HitBox hitBox;
    private final Map<String, Command> components;
    private Vector velocity;
    private Map<String, Object> entityVar;

    /**
     * Create an Entity.
     * @param position where position have to be set
     * @param drawable set if the block will be drawn
     * @param graphic for render the block
     */
    protected GameEntity(final Vector position, final boolean drawable) {
        final int size = GameFactory.loadSettings().scale();
        this.drawable = drawable;
        this.components = new HashMap<>();
        this.hitBox = new GameHitBox(position, new Vector2D(size * Constant.DEFAULT_HITBOX_DIMENSION,
                size * Constant.DEFAULT_HITBOX_DIMENSION));
        this.entityVar = new HashMap<>();
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
    public void addComponent(String code, Command component) {
        this.components.put(code, component);
    }

    @Override
    public Command component(String code) {
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
    public <T, K> void update(String componentName, Controller<T, K> componentController) {
        if(this.components.containsKey(componentName)){
            this.components.get(componentName).update(this, componentController, null);
        }
    }

    @Override
    public void setVelocity(Vector direction) {
        this.velocity = direction;
    }

    @Override
    public Vector getVelocity() {
        return this.velocity;
    }

    @Override
    public void addVar(String code, Object var) {
        this.entityVar.put(code, var);
    }

    @Override
    public Object var(String code) {
        return this.entityVar.get(code);
    }
}
