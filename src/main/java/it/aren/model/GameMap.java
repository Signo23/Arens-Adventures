/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.graphic.GameMapGraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputController;

/**
 * 
 *
 */
public class GameMap extends Entity {

    private int width;
    private int height;
    private List<Block> blocks;

    public GameMap(final int width, final int height, final List<Block> blocks) {
        super(new Point2D(), true, new GameMapGraphicComponent(), null);
        this.width = width;
        this.height = height;
        this.blocks = blocks;
    }
    
    public GameMap(final int width, final int height) {
        this(width, height, new ArrayList<>());
    }
    
    public GameMap() {
        this(Constant.DEFAULT_MAP_DIMENSION, Constant.DEFAULT_MAP_DIMENSION, new ArrayList<>());
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(final int height) {
        this.height = height;
    }

    /**
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(final List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
        this.blocks.forEach(b -> b.updateGraphic(g));
        
    }

    @Override
    public void updateInput(final InputController i) {
        
    }
    
}
