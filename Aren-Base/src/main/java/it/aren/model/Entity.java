package it.aren.model;

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

    void addComponent(String code, Component component);
    Component component(String code);

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

    abstract <T> void update(String componentName, Controller<T> componentController);

    void setVelocity(Direction velocity);
    Direction getVelocity();
}
