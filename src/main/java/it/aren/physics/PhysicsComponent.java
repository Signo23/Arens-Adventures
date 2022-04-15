/**
 * 
 */
package it.aren.physics;

import it.aren.model.Entity;

/**
 * A component for physics.
 *
 */
public interface PhysicsComponent {
    
    /**
     * Update the {@link Entity}.
     * @param entity {@link Entity} to update
     */
    void update(Entity entity);
}
