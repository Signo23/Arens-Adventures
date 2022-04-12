/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.Player;

/**
 * 
 *
 */
public interface GraphicController {

    /**
     * Draw the player.
     * @param player to draw
     */
    void drawPlayer(Player player);

    /**
     * Draw the block.
     * @param block to draw
     */
    void drawBlock(Block block);
    void drawGameMap(GameMap gameMap);
}
