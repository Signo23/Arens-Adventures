package it.aren.physics;

import it.aren.common.Constant;
import it.aren.model.Direction;
import it.aren.model.Vector2D;
import it.aren.file.SettingsLoader;
import it.aren.model.BaseEntity;
import it.aren.model.Vector;
import it.aren.model.game.Player;

/**
 * The physics component for {@link Player}.
 * Implements {@link PhysicsComponent}
 */
public class PlayerPhysicsComponent implements PhysicsComponent {

    private final int velocity;

    public PlayerPhysicsComponent() {
        this.velocity = SettingsLoader.loadSettings().scale() * Constant.DEFAULT_VEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final BaseEntity player) {
        final Player pl = (Player) player;
        if (!pl.getVelocity().equals(Direction.NO_DIRECTION)) {
            final Direction pos = pl.getLastDirection();
            final Vector currentPos = pl.getPosition();
            switch (pos) {
            case LEFT:
                pl.setPosition(new Vector2D(currentPos.getX() - velocity, currentPos.getY()));
                break;
            case RIGHT:
                pl.setPosition(new Vector2D(currentPos.getX() + velocity, currentPos.getY()));
                break;
            case UP:
                pl.setPosition(new Vector2D(currentPos.getX(), currentPos.getY() - velocity));
                break;
            case DOWN:
                pl.setPosition(new Vector2D(currentPos.getX(), currentPos.getY() + velocity));
                break;
            default:
                break;
            }
         }
    }
}