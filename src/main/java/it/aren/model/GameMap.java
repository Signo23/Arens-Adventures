/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.BaseLevelEnum;
import it.aren.common.Constant;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.event.NullEvent;
import it.aren.file.SettingsLoader;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.GameMapGraphicComponent;
import it.aren.graphic.GraphicController;

/**
 * The map of the block
 *
 */
public class GameMap extends BaseEntity {
    private List<Block> blocks;
    private final BaseLevelEnum type;
    /**
     * Create a map without block and default {@link Constant}.
     */
    public GameMap(final BaseLevelEnum type) {
        super(new Point2D(), true, new GameMapGraphicComponent());
        this.blocks = new ArrayList<>();
        this.type = type;
    }

    public void addBlock(final Block block) {
        this.blocks.add(block);
    }

    @Override
    /**
     * 
     */
    public void updateGraphic(final GraphicController g) {
        super.updateGraphic(g);
        this.blocks.forEach(b -> b.updateGraphic(g));
    }

    /**
     * Get GameMap's list of {@link Block}.
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return this.blocks;
    }

    /**
     * Set GameMap's list of {@link Block}.
     * @param blocks the blocks to set
     */
    public void setBlocks(final List<Block> blocks) {
        this.blocks = blocks;
    }

    public BaseLevelEnum getType() {
        return type;
    }
    
}
