package it.aren.input;

import it.aren.model.GameEntity;
import it.aren.model.BaseEntity;

/**
 * The input component interface to update the input.
 */
public interface InputComponent {
    /**
     * Update the {@link GameEntity} based on the {@link InputController}.
     * @param entity the {@link GameEntity} to update
     * @param controller the {@link InputController} to use for update entity
     */
    void update(BaseEntity entity, InputController controller);
}
