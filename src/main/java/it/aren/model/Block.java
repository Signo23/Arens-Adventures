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
 * 
 */
public class Block extends Entity {

    private Event event;

    public Block(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input) {
        super(position, drawable, graphic, input);
        this.event = new NullEvent();
    }

    @Override
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    @Override
    public void updateInput(final InputController i) {
        if(this.input != null) {
            this.input.update(this, i);
        }
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
