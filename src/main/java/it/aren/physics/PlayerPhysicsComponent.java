/**
 * 
 */
package it.aren.physics;

import it.aren.common.Constant;
import it.aren.common.Direction;
import it.aren.common.Point2D;
import it.aren.file.SettingsLoader;
import it.aren.model.BaseEntity;
import it.aren.model.Player;

/**
 * The physics component for {@link Player}.
 * Implements {@link PhysicsComponent}
 */
public class PlayerPhysicsComponent implements PhysicsComponent {
    
    private final int velocity;
    
    public PlayerPhysicsComponent() {
        this.velocity = SettingsLoader.loadSettings().scale() * Constant.DEFAULT_VEL;
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final BaseEntity player) {
        final Player pl = (Player)player;
        if(!pl.isIdle()) {
            final Direction pos = pl.getLastDirection();
            final Point2D currentPos = pl.getPosition();
            switch(pos) {
            case LEFT:
                pl.setPosition(new Point2D(currentPos.getX() - velocity, currentPos.getY()));
                break;
            case RIGHT:
                pl.setPosition(new Point2D(currentPos.getX() + velocity, currentPos.getY()));
                break;
            case UP:
                pl.setPosition(new Point2D(currentPos.getX(), currentPos.getY() - velocity));
                break;
            case DOWN:
                pl.setPosition(new Point2D(currentPos.getX(), currentPos.getY() + velocity));
                break;
            default:
                break;
            }
         }
    }
}