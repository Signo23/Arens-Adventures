/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * Graphic for {@link Player}.
 * Implements {@link GraphicComponent}
 */
public class PlayerGraphicComponent implements GraphicComponent {


    private final Animation animation;
    
    public PlayerGraphicComponent(final Texture texture) {
        this.animation = new Animation(Player.class, texture);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final Entity player, final GraphicController g) {
        final Player tmpPlayer = (Player)player;
        g.drawPlayer(player.getPosition(), tmpPlayer.isIdle() ? this.animation.getNextIdle(tmpPlayer.getLastDirection())
                : this.animation.getNextWalk(tmpPlayer.getLastDirection()));
    }

}
