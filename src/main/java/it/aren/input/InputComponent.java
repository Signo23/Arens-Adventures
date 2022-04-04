package it.aren.input;

import it.aren.model.Entity;

public interface InputComponent {
    void update(Entity entity, InputController controller);
}
