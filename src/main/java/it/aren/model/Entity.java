/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;

public abstract class Entity {
    private Point2D position;
    private boolean drawable;
    protected GraphicComponent graphic;
    protected InputComponent input;
    /**
     * @param position
     * @param drawble
     */
    public Entity(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input) {
        this.position = position;
        this.drawable = drawable;
        this.graphic = graphic;
        this.input = input;
    }
    /**
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }
    /**
     * @param position the position to set
     */
    public void setPosition(final Point2D position) {
        this.position = position;
    }
    /**
     * @return the drawable
     */
    public boolean isDrawable() {
        return drawable;
    }
    /**
     * @param drawable the drawable to set
     */
    public void setDrawable(final boolean drawable) {
        this.drawable = drawable;
    }
    /**
     * @return the graphic
     */
    public GraphicComponent getGraphic() {
        return graphic;
    }
    /**
     * @param graphic the graphic to set
     */
    public void setGraphic(final GraphicComponent graphic) {
        this.graphic = graphic;
    }
    /**
     * @return the input
     */
    public InputComponent getInput() {
        return input;
    }
    /**
     * @param input the input to set
     */
    public void setInput(final InputComponent input) {
        this.input = input;
    }
    /**
     * 
     * @param g GraphicController that update the entity
     */
    public abstract void updateGraphic(GraphicController g);
    public abstract void updateInput(InputController i);
    
    

    
}
