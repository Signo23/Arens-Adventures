/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;
import it.aren.event.Event;
import it.aren.event.NullEvent;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;

/**
 * Model for every block.
 * Extends {@link Entity}
 */
public class Block extends Entity {

    private Event event;

    /**
     * Create a Block.
     * @param position where block is
     * @param drawable set if the block will be drawn
     * @param graphic for draw the block
     * @param input for listen the input
     */
    public Block(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input) {
        super(position, drawable, graphic, input);
        this.event = new NullEvent();
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void updateInput(final InputController i) {
        this.input.update(this, i);
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
