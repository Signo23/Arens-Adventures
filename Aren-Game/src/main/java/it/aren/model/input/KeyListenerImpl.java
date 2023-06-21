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
    public final void keyTyped(final KeyEvent e) {
        if(KeyEvent.VK_SPACE == e.getExtendedKeyCode()){
            this.controller.update(InputController.INTERACT, true);
        }
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public final void keyPressed(final KeyEvent e) {
        System.out.println("PRESS" + e.getKeyChar());
        handleKeyEvent(e, true);
    }

    private void handleKeyEvent(KeyEvent e, boolean value) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                this.controller.update(InputController.UP, value);
                break;
            case KeyEvent.VK_S:
                this.controller.update(InputController.DOWN, value);
                break;
            case KeyEvent.VK_A:
                this.controller.update(InputController.LEFT, value);
                break;
            case KeyEvent.VK_D:
                this.controller.update(InputController.RIGHT, value);
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
        System.out.println("STOP" + e.getKeyChar());
        handleKeyEvent(e, false);
    }
}
