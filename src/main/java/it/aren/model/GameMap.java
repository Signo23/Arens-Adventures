/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Constant;

/**
 * The map of the block
 *
 */
public class GameMap {

    private int width;
    private int height;
    private List<Block> blocks;

    /**
     * Create a map.
     * @param width of the map
     * @param height of the map
     * @param blocks to add in the map
     */
    public GameMap(final int width, final int height, final List<Block> blocks) {
        this.width = width;
        this.height = height;
        this.blocks = blocks;
    }
    
    /**
     * Create a map without block
     * @param width of the map
     * @param height of the map
     */
    public GameMap(final int width, final int height) {
        this(width, height, new ArrayList<>());
    }
    
    /**
     * Create a map without block and default {@link Constant}.
     */
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
    
}
