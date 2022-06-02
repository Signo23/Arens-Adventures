/**
 * 
 */
package it.aren.graphic;

import it.aren.model.BaseEntity;
import it.aren.model.Player;

/**
 * Graphic for {@link Player}.
 * Implements {@link GraphicComponent}
 */
public class PlayerGraphicComponent implements GraphicComponent {


    private final Animation animation;
    
    public PlayerGraphicComponent(final Texture texture) {
        this.animation = new Animation(texture);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final BaseEntity player, final GraphicController g) {
        final Player tmpPlayer = (Player)player;
        g.drawPlayer(player.getPosition(), tmpPlayer.isIdle() ? this.animation.getNextIdle(tmpPlayer.getLastDirection())
                : this.animation.getNextWalk(tmpPlayer.getLastDirection()));
    }

}
