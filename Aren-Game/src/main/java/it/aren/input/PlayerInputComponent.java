package it.aren.input;

import it.aren.common.Direction;
import it.aren.model.BaseEntity;
import it.aren.model.Component;
import it.aren.model.Controller;
import it.aren.model.game.Player;

/**
 * The input component for the {@link Player}.
 * Implements {@link InputComponent}
 */
public class PlayerInputComponent implements Component {

    @Override
    public <T, C extends Controller<T>> void update(BaseEntity entity, C controller) {
        if(controller instanceof InputController) {
            final String action = ((InputController)controller).getAction();
            if (action.equals(InputController.UP)) {
                ((Player) entity).setLastDirection(Direction.UP);
                ((Player) entity).setIdle(false);
            } else if (action.equals(InputController.DOWN)) {
                ((Player) entity).setLastDirection(Direction.DOWN);
                ((Player) entity).setIdle(false);
            } else if (action.equals(InputController.LEFT)) {
                ((Player) entity).setLastDirection(Direction.LEFT);
                ((Player) entity).setIdle(false);
            } else if (action.equals(InputController.RIGHT)) {
                ((Player) entity).setLastDirection(Direction.RIGHT);
                ((Player) entity).setIdle(false);
            } else {
                ((Player) entity).setIdle(true);
            }
        }
    }
}
