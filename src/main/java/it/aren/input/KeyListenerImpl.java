/**
 * 
 */
package it.aren.input;

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
                this.controller.notifyMoveUp();
                break;
            case KeyEvent.VK_S:
                this.controller.notifyMoveDown();
                break;
            case KeyEvent.VK_A:
                this.controller.notifyMoveLeft();
                break;
            case KeyEvent.VK_D:
                this.controller.notifyMoveRight();
                break;
            case KeyEvent.VK_SPACE:
                this.controller.notifyInteract();
                break;
            case KeyEvent.VK_ENTER:
                this.controller.notifyOnClose();
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                this.controller.notifyNoMoreMoveUp();
                break;
            case KeyEvent.VK_S:
                this.controller.notifyNoMoreMoveDown();
                break;
            case KeyEvent.VK_A:
                this.controller.notifyNoMoreMoveLeft();
                break;
            case KeyEvent.VK_D:
                this.controller.notifyNoMoreMoveRight();
                break;
            case KeyEvent.VK_SPACE:
                this.controller.notifyNoMoreInteract();
                break;
            case KeyEvent.VK_ENTER:
                this.controller.notifyNoMoreOnClose();
                break;
            default:
                break;
        }
    }
}
