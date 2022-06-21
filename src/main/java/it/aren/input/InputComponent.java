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
     * Update the {@link BaseEntity} based on the {@link InputController}.
     * @param entity the {@link BaseEntity} to update
     * @param controller the {@link InputController} to use for update entity
     */
    void update(BaseEntity entity, InputController controller);
}
