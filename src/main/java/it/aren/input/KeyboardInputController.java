package it.aren.input;

public class KeyboardInputController implements InputController {

    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveLeft;
    private boolean isMoveRight;

    /**
     * @return isMoveUp
     */
    public final boolean isMoveUp() {
        return isMoveUp;
    }

    /**
     * @return isMoveDown
     */
    public final boolean isMoveDown() {
        return isMoveDown;
    }

    /**
     * @return isMoveLeft
     */
    public final boolean isMoveLeft() {
        return isMoveLeft;
    }

    /**
     * @return isMoveRight
     */
    public final boolean isMoveRight() {
        return isMoveRight;
    }


    public final void notifyMoveUp() {
        isMoveUp = true;
    }

    public final void notifyNoMoreMoveUp() {
        isMoveUp = false;
    }

    public final void notifyMoveDown() {
        isMoveDown = true;
    }

    public final void notifyNoMoreMoveDown() {
        isMoveDown = false;
    }

    public final void notifyMoveLeft() {
        isMoveLeft = true;
    }

    public final void notifyNoMoreMoveLeft() {
        isMoveLeft = false;
    }

    public final void notifyMoveRight() {
        isMoveRight = true;
    }

    public final void notifyNoMoreMoveRight() {
        isMoveRight = false;
    }
}
