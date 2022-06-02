/**
 * 
 */
package it.aren.physics;

import it.aren.model.BaseEntity;

/**
 * A component for physics.
 *
 */
public interface PhysicsComponent {
    
    /**
     * Update the {@link BaseEntity}.
     * @param entity {@link BaseEntity} to update
     */
    void update(BaseEntity entity);
}
