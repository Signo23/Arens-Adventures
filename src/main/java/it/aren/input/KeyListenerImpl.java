package it.aren.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerImpl implements KeyListener {

    private final KeyboardInputController controller;

    public KeyListenerImpl(final KeyboardInputController controller) {
        this.controller = controller;
    }

    @Override
    public final void keyTyped(final KeyEvent e) { }

    @Override
    public final void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                controller.notifyMoveUp();
                break;
            case KeyEvent.VK_S:
                controller.notifyMoveDown();
                break;
            case KeyEvent.VK_A:
                controller.notifyMoveLeft();
                break;
            case KeyEvent.VK_D:
                controller.notifyMoveRight();
                break;
            default:
                break;
        }
    }

    @Override
    public final void keyReleased(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                controller.notifyNoMoreMoveUp();
                break;
            case KeyEvent.VK_S:
                controller.notifyNoMoreMoveDown();
                break;
            case KeyEvent.VK_A:
                controller.notifyNoMoreMoveLeft();
                break;
            case KeyEvent.VK_D:
                controller.notifyNoMoreMoveRight();
                break;
            default:
                break;
        }
    }
}
