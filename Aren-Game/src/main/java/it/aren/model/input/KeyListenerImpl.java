package it.aren.model.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * The listener for the keyboard.
 * Implements {@link KeyListener}
 */
public class KeyListenerImpl implements KeyListener {

    private final KeyboardInputController controller;

    /**
     * Set the controller received from the keyboard.
     * @param controller the controller to set
     */
    public KeyListenerImpl(final KeyboardInputController controller) {
        this.controller = controller;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public final void keyTyped(final KeyEvent e) { }

    @Override
    /**
     * {@inheritDoc}
     */
    public final void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                this.controller.update(InputController.UP);
                break;
            case KeyEvent.VK_S:
                this.controller.update(InputController.DOWN);
                break;
            case KeyEvent.VK_A:
                this.controller.update(InputController.LEFT);
                break;
            case KeyEvent.VK_D:
                this.controller.update(InputController.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                this.controller.update(InputController.INTERACT);
                break;
            case KeyEvent.VK_ENTER:
                this.controller.update(InputController.ON_CLOSE_DIALOG);
                break;
            default:
                break;
        }
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public final void keyReleased(final KeyEvent e) {
        this.controller.update(InputController.NO_ACTION);
    }
}
