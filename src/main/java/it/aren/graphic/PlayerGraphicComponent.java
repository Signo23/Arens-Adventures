/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * Graphic for {@link Player}.
 *
 */
public class PlayerGraphicComponent implements GraphicComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final Entity player, final GraphicController g) {
        g.drawPlayer((Player)player);
    }

}
