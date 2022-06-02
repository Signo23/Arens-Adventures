/**
 * 
 */
package it.aren.model;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.event.Event;
import it.aren.event.NullEvent;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;

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
     */
    public Block(final Point2D position, final boolean drawable, final GraphicComponent graphic) {
        this(new NullEvent() ,position, drawable, graphic, Constant.DEFAULT_HITBOX_DIMENSION);
    }
    
    /**
     * Create a Block.
     * @param event the {@link Event} to set in the block
     * @param position where block is
     * @param drawable set if the block will be drawn
     * @param graphic for draw the block
     * @param hitboxDimension dimension of hiBox
     */
    public Block(final Event event, final Point2D position, final boolean drawable, final GraphicComponent graphic, final int hitboxDimension) {
        super(position, drawable, graphic, null, hitboxDimension);
        this.event = event;
        this.hitBox.setSize(hitboxDimension, hitboxDimension / 2);
    }
    
    /**
     * Create a Block.
     * @param event the {@link Event} to set in the block
     * @param position where block is
     * @param drawable set if the block will be drawn
     * @param graphic for draw the block
     */
    public Block(final Event event, final Point2D position, final boolean drawable, final GraphicComponent graphic){
        this(event, position, drawable, graphic, Constant.DEFAULT_HITBOX_DIMENSION);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void updateGraphic(final GraphicController g) {
        if(this.isDrawable()) {
            this.graphic.update(this, g);   
        }
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
