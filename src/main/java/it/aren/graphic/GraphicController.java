package it.aren.graphic;

import java.awt.image.BufferedImage;

import it.aren.common.Point2D;
import it.aren.model.BaseEntity;
import it.aren.model.game.Block;
import it.aren.model.game.Dialog;
import it.aren.model.game.GameMap;
import it.aren.model.game.GameObject;

/**
 * Interface for drawing entities.
 *
 */
public interface GraphicController {
    void draw(BaseEntity entity);

}
