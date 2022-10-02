package it.aren.model.physics;

import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.model.*;
import it.aren.file.SettingsLoader;
import it.aren.model.game.Player;

/**
 * The physics component for {@link Player}.
 * Implements {@link PhysicsComponent}
 */
public class PlayerPhysicsComponent implements Component {

    private final int velocity;

    public PlayerPhysicsComponent() {
        final SettingsLoader settingsLoader = new SettingsLoader();
        final Settings settings = settingsLoader.loadFile(Constant.SETTINGS_FILE);
        this.velocity = settings.scale() * Constant.DEFAULT_VEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, C extends Controller<T>> void update(Entity entity, C controller) {
        final Player pl = (Player) entity;
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