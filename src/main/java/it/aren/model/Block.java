/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;
import it.aren.event.Event;
import it.aren.event.NullEvent;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.GraphicController;

/**
 * 
 */
public class Block extends Entity {

    private Event event;

    public Block(final Point2D position, final boolean drawable, final BlockGraphicComponent graphic) {
        super(position, drawable, graphic);
        this.event = new NullEvent();
    }

    @Override
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(final Event event) {
        this.event = event;
    }

    

}
