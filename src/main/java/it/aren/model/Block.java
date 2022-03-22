/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;
import it.aren.event.Event;
import it.aren.event.NullEvent;

/**
 * 
 */
public class Block extends Entity {

    private Event event;

    public Block(final Point2D position, final boolean drawable) {
        super(position, drawable);
        this.event = new NullEvent();
    }

    @Override
    public void updateGraphic() {
        // TODO when graphic is implemented

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
