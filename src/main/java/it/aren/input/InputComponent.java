/**
 * 
 */
package it.aren.input;

import it.aren.model.BaseEntity;
/**
 * The input component interface to update the input.
 */
public interface InputComponent {
    /**
     * Update the entity based on the controller.
     * @param entity to update
     * @param controller to use for update entity
     */
    void update(BaseEntity entity, InputController controller);
}
