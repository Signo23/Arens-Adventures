/**
 * 
 */
package it.aren.input;

import it.aren.model.Entity;
/**
 * The input component interface to update the input.
 */
public interface InputComponent {
    /**
     * Update the entity based on the controller.
     * @param entity to update
     * @param controller to use for update entity
     */
    void update(Entity entity, InputController controller);
}
