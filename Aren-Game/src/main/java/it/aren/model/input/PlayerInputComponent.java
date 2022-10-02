package it.aren.model.input;

import it.aren.Direction;
import it.aren.Entity;
import it.aren.Controller;
import it.aren.model.GameComponent;
import it.aren.model.game.Player;

/**
 * The input component for the {@link Player}.
 * Implements {@link InputComponent}
 */
public class PlayerInputComponent extends GameComponent {

    @Override
    public <T, C extends Controller<T>> void update(Entity entity, C controller) {
        if(controller instanceof InputController) {
            final String action = ((InputController)controller).getAction();
            if (action.equals(InputController.UP)) {
                ((Player) entity).setLastDirection(Direction.UP);
                entity.setVelocity(Direction.UP);
            } else if (action.equals(InputController.DOWN)) {
                ((Player) entity).setLastDirection(Direction.DOWN);
                entity.setVelocity(Direction.DOWN);
            } else if (action.equals(InputController.LEFT)) {
                ((Player) entity).setLastDirection(Direction.LEFT);
                entity.setVelocity(Direction.LEFT);
            } else if (action.equals(InputController.RIGHT)) {
                ((Player) entity).setLastDirection(Direction.RIGHT);
                entity.setVelocity(Direction.RIGHT);
            } else {
                entity.setVelocity(Direction.NO_DIRECTION);
            }
        }
    }
}
