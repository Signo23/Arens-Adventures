package it.aren;

public interface Entity {
    /**
     * Get Entity's position.
     *
     * @return the position
     */
    Vector getPosition();

    /**
     * Set Entity's position.
     *
     * @param position the position to set
     */
    void setPosition(Vector position);

    /**
     * Get if Entity is drawable.
     *
     * @return the drawable
     */
    boolean isDrawable();

    /**
     * Set if Entity is drawable.
     *
     * @param drawable the drawable to set
     */
    void setDrawable(boolean drawable);

    void addComponent(String code, Command component);
    Command component(String code);

    /**
     * Get Entity's {@link HitBox} for hitBox.
     *
     * @return the hitBox
     */
    HitBox getHitBox();

    /**
     * Set Entity's {@link HitBox} for hitBox.
     *
     * @param hitBox the Rectangle to set
     */
    void setHitBox(HitBox hitBox);

    abstract <T, K> void update(String componentName, Controller<T, K> componentController);

    void setVelocity(Vector velocity);
    Vector getVelocity();
    void addVar(String code, Object var);
    Object var(String code);
}
