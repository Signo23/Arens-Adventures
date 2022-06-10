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
import it.aren.common.PointRange;
import it.aren.event.NullEvent;
import it.aren.file.MapsLoader;
import it.aren.file.SettingsLoader;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.GameMapGraphicComponent;
import it.aren.graphic.GraphicController;

/**
 * The map of the block.
 *
 */
public class GameMap extends BaseEntity {
    private List<Block> blocks;
    private final BaseLevelEnum type;
    /**
     * Create a map.
     * @param type
     */
    public GameMap(final BaseLevelEnum type) {
        super(new Point2D(), true, new GameMapGraphicComponent());
        this.blocks = new ArrayList<>();
        this.type = type;
        type.getPoints().forEach(p -> this.addBlocks(createLineBlock(p)));
    }

    private static List<Block> createLineBlock(final PointRange range) {
        final int ratio = SettingsLoader.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;
        final List<Block> blocks = new ArrayList<>();
        for (int i = (int) range.getStart().getX(); i <= (int) range.getEnd().getX(); i++) {
            for (int j = (int) range.getStart().getY(); j <= (int) range.getEnd().getY(); j++) {
                blocks.add(createSimpleBlock(new Point2D(i * dimension, j * dimension)));
            }
        }
        return blocks;
    }

    private static Block createSimpleBlock(final Point2D position) {
        return new Block(BaseObjectEnum.VOID, new NullEvent(), position,
                true, new BlockGraphicComponent());
    }

    public final void addBlock(final Block block) {
        this.blocks.add(block);
    }


    /**
     * 
     */
    @Override
    public final void updateGraphic(final GraphicController g) {
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
    
    public void addBlocks (final List<Block> blocks) {
        this.blocks.addAll(blocks);
    }

    public final BaseLevelEnum getType() {
        return type;
    }

}
