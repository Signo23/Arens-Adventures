package it.aren.graphic;

import java.awt.image.BufferedImage;

import it.aren.common.Point2D;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.GameObject;

/**
 * Interface for drawing entities.
 *
 */
public interface GraphicController {

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

    /**
     * Draw {@link it.aren.model.Player}.
     * @param playerPosition the player's position where to draw 
     * @param sprite the {@link BufferedImage} to draw
     */
    void drawPlayer(Point2D playerPosition, BufferedImage sprite);

    /**
     * Draw {@link GameObject}.
     * @param obj the {@link GameObject} to draw
     */
    void drawObject(GameObject obj);

    /**
     * Draw {@link Dialog}.
     * @param dialog the {@link Dialog} to draw
     */
    void drawDialog(Dialog dialog);
}
