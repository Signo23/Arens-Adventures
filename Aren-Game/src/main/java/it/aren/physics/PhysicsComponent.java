package it.aren.physics;

import it.aren.model.GameEntity;
import it.aren.model.BaseEntity;

/**
 * A component for physics.
 *
 */
public interface PhysicsComponent {

    /**
     * Update the {@link GameEntity}.
     * @param entity {@link GameEntity} to update
     */
    void update(BaseEntity entity);
}
