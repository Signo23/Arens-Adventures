package it.aren.graphic;

import java.awt.image.BufferedImage;

import it.aren.common.Point2D;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.GameObject;
import it.aren.model.Player;

/**
 * Interface for drawing entities.
 *
 */
public interface GraphicController {

    /**
     * @deprecated
     * Draw {@link Player}
     * @param player the {@link Player} to draw
     */
    void drawPlayer(Player player);

    /**
     * Draw {@link Block}.
     * @param block the {@link Block} to draw
     */
    void drawBlock(Block block);

    /**
     * Draw {@link GameMap}.
     * @param gameMap the {@link GameMap} to draw
     */
    void drawGameMap(GameMap gameMap);

    void drawPlayer(Point2D playerPosition, BufferedImage sprite);

    /**
     * Draw {@link GameObject}.
     * @param obj the {@link GameObject} to draw
     */
    void drawObject(GameObject obj);

    void drawDialog(Dialog dialog);
}
