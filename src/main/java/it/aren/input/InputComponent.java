package it.aren.input;

import it.aren.model.Player;

public interface InputComponent {
    void update(Player player, InputController controller);
}
