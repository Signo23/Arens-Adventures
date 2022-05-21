/**
 * 
 */
package it.aren.model;

import java.awt.Rectangle;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;
/**
 * The main model of the game.
 *
 */
public abstract class Entity {
    private Point2D position;
    private boolean drawable;
    private Rectangle hitBox;
    protected GraphicComponent graphic;
    protected InputComponent input;
    /**
     * Create an Entity.
     * @param position where position have to be set
     * @param drawable set if the block will be drawn
     * @param graphic for render the block
     * @param input for listen the block's input
     * @param size hitbox's {@link Rectangle} px size for sides
     */
    public Entity(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final int size) {
        this.position = position;
        this.drawable = drawable;
        this.graphic = graphic;
        this.input = input;
        this.hitBox = new Rectangle(size, size);
        this.hitBox.setLocation((int)this.position.getX(), (int)this.position.getY());
    }
    /**
     * Get Entity's position.
     * @return the position
     */
    public Point2D getPosition() {
        return this.position;
    }
    /**
     * Set Entity's position.
     * @param position the position to set
     */
    public void setPosition(final Point2D position) {
        this.position = position;
        this.hitBox.setLocation((int)position.getX(), (int)position.getY());
    }
    /**
     * Get if Entity is drawable.
     * @return the drawable
     */
    public boolean isDrawable() {
        return this.drawable;
    }
    /**
     * Set if Entity is drawable.
     * @param drawable the drawable to set
     */
    public void setDrawable(final boolean drawable) {
        this.drawable = drawable;
    }
    /**
     * Get Entity's {@link GraphicComponent}
     * @return the graphic
     */
    public GraphicComponent getGraphic() {
        return this.graphic;
    }
    /**
     * Set Entity's {@link GraphicComponent}
     * @param graphic the graphic to set
     */
    public void setGraphic(final GraphicComponent graphic) {
        this.graphic = graphic;
    }
    /**
     * Get Entity's {@link InputComponent}
     * @return the input
     */
    public InputComponent getInput() {
        return this.input;
    }
    /**
     * Set Entity's {@link InputComponent}
     * @param input the input to set
     */
    public void setInput(final InputComponent input) {
        this.input = input;
    }
    /**
     * Get Entity's {@link Rectangle} for hitbox;
     * @return the hitBox
     */
    public Rectangle getHitBox() {
        return hitBox;
    }
    /**
     * Set Entity's {@link Rectangle} for hitbox.
     * @param hitBox the Rectangle to set
     */
    public void setHitBox(final Rectangle hitBox) {
        this.hitBox = hitBox;
    }
    /**
     * Update the Entity's {@link GraphicComponent}.
     * @param g {@link GraphicController} that update the entity
     */
    public abstract void updateGraphic(GraphicController g);
    /**
     * Update the Entity's {@link InputComponent}.
     * @param i {@link} that update the Entity
     */
    public abstract void updateInput(InputController i);
    
    

    
}
