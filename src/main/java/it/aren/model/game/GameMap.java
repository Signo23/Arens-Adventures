package it.aren.model.game;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.BaseLevelEnum;
import it.aren.common.Constant;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.common.PointRange;
import it.aren.event.NullEvent;
import it.aren.file.SettingsLoader;
import it.aren.graphic.GraphicController;
import it.aren.graphic.component.BlockGraphicComponent;
import it.aren.graphic.component.GameMapGraphicComponent;
import it.aren.model.BaseEntity;

/**
 * Represent a map of game.
 *
 */
public class GameMap extends BaseEntity {
    private List<Block> blocks;
    private final BaseLevelEnum type;
    /**
     * Create a map.
     * @param type the {@link BaseLevelEnum} type of map
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

    /**
     * Add a block in the map.
     * @param block the {@link Block} to add in the map
     */
    public final void addBlock(final Block block) {
        this.blocks.add(block);
    }

    /**
     * Add a {@link List} of block in the map.
     * @param block the {@link Block} to add in the map
     */ 
    void addBlocks(final List<Block> blocks) {
        this.blocks.addAll(blocks);
    }

    /**
     * {@inheritDoc}
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

    /**
     * Get the type of map.
     * @return {@link BaseLevelEnum} type of map
     */
    public final BaseLevelEnum getType() {
        return type;
    }

}
