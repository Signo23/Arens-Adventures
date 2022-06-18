package it.aren.model.game;

import it.aren.common.Constant;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.event.Event;
import it.aren.file.SettingsLoader;
import it.aren.graphic.GraphicComponent;

/**
 * Model for every block.
 * Extends {@link BaseEntity}
 */
public class Block extends GameObject {

    private Event event;
    /**
     * Create a Block.
     * @param event the {@link Event} to set in the block
     * @param position where block is
     * @param drawable set if the block will be drawn
     * @param graphic for draw the block
     * @param ratio ratio for hiBox
     */
    public Block(final BaseObjectEnum type, final Event event, final Point2D position, final boolean drawable, final GraphicComponent graphic) {
        super(type, position, drawable, graphic);
        final int ratio = SettingsLoader.loadSettings().scale();
        this.event = event;
        this.hitBox.setSize(ratio * Constant.DEFAULT_HITBOX_DIMENSION, ratio * Constant.DEFAULT_HITBOX_DIMENSION / 2);
    }

    /**
     * Get the block's {@link Event}.
     * @return the event
     */
    public Event getEvent() {
        return this.event;
    }

    /**
     * Set the block's {@link Event}.
     * @param event the event to set
     */
    public void setEvent(final Event event) {
        this.event = event;
    }
}
