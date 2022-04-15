/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.Player;

/**
 * Interface for drawing entities.
 *
 */
public interface GraphicController {

    /**
     * Draw {@link Player}
     * @param player the {@link Player} to draw
     */
    void drawPlayer(Player player);

    /**
     * Draw {@link Block}
     * @param block the {@link Block} to draw
     */
    void drawBlock(Block block);

    /**
     * Draw {@link GameMap}
     * @param gameMap the {@link GameMap} to draw
     */
    void drawGameMap(GameMap gameMap);
}
