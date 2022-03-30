/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Block;
import it.aren.model.Entity;

/**
 * @author 
 *
 */
public class BlockGraphicComponent implements GraphicComponent {

    @Override
    public void update(final Entity ent, final GraphicController w) {
        w.drawBlock((Block)ent);

    }

}
