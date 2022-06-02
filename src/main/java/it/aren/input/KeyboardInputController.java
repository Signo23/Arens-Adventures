/**
 * 
 */
package it.aren.input;
/**
 * The input controller for the keyboard.
 * Implements {@link InputController}
 */
public class KeyboardInputController implements InputController {

    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveLeft;
    private boolean isMoveRight;
    private boolean isInteract;
    private boolean isOnClose;

    /**
     * Return isMoveUp. 
     * @return isMoveUp
     */
    public final boolean isMoveUp() {
        return this.isMoveUp;
    }

    /**
     * Return isMoveDown.
     * @return isMoveDown
     */
    public final boolean isMoveDown() {
        return this.isMoveDown;
    }

    /**
     * Return isMoveLeft.
     * @return isMoveLeft
     */
    public final boolean isMoveLeft() {
        return this.isMoveLeft;
    }

    /**
     * Return isMoveRiight.
     * @return isMoveRight
     */
    public final boolean isMoveRight() {
        return this.isMoveRight;
    }

    /**
     * Return isInteract.
     * @return isInteract
     */
    public final boolean isInteract() {
        return this.isInteract;
    }

    /**
     * Return isOnClose.
     * @return isOnClose
     */
    public final boolean isOnClose() {
        return this.isOnClose;
    }

    /**
     * Set isMoveUp to true.
     */
    public final void notifyMoveUp() {
        this.isMoveUp = true;
    }

    /**
     * Set isMoveUp to false.
     */
    public final void notifyNoMoreMoveUp() {
        this.isMoveUp = false;
    }

    /**
     * Set isMoveDown to true.
     */
    public final void notifyMoveDown() {
        this.isMoveDown = true;
    }

    /**
     * Set isMoveDown to false.
     */
    public final void notifyNoMoreMoveDown() {
        this.isMoveDown = false;
    }

    /**
     * Set isMoveLeft to true.
     */
    public final void notifyMoveLeft() {
        this.isMoveLeft = true;
    }

    /**
     * Set isMoveLeft to false.
     */
    public final void notifyNoMoreMoveLeft() {
        this.isMoveLeft = false;
    }

    /**
     * Set isMoveRight to true.
     */
    public final void notifyMoveRight() {
        this.isMoveRight = true;
    }

    /**
     * Set isMoveRight to false.
     */
    public final void notifyNoMoreMoveRight() {
        this.isMoveRight = false;
    }

    /**
     * Set isInteract to true.
     */
    public final void notifyInteract() {
        this.isInteract = true;
    }

    /**
     * Set isInteract to false.
     */
    public final void notifyNoMoreInteract() {
        this.isInteract = false;
    }

    /**
     * Set isOnClose to true.
     */
    public final void notifyOnClose() {
        this.isOnClose = true;
    }

    /**
     * Set isOnClose to false.
     */
    public final void notifyNoMoreOnClose() {
        this.isOnClose = false;
    }
}
