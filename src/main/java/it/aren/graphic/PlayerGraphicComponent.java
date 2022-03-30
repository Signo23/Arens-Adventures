/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * @author lory4
 *
 */
public class PlayerGraphicComponent implements GraphicComponent {

    @Override
    public void update(final Entity player, final GraphicController g) {
        g.drawPlayer((Player)player);
    }

}
