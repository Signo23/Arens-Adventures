package it.aren.graphic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.aren.input.KeyboardInputController;

public class KeyListenerImpl implements KeyListener {

    private final KeyboardInputController controller;

    public KeyListenerImpl(final KeyboardInputController controller) {
        this.controller = controller;
    }

    @Override
    public final void keyTyped(final KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            controller.notifyMoveUp();
        } else if (e.getKeyChar() == 's') {
            controller.notifyMoveDown();
        } else if (e.getKeyChar() == 'a') {
            controller.notifyMoveLeft();
        } else if (e.getKeyChar() == 'd') {
            controller.notifyMoveRight();
        }
    }

    @Override
    public void keyPressed(final KeyEvent e) { }

    @Override
    public final void keyReleased(final KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            controller.notifyNoMoreMoveUp();
        } else if (e.getKeyChar() == 's') {
            controller.notifyNoMoreMoveDown();
        } else if (e.getKeyChar() == 'a') {
            controller.notifyNoMoreMoveLeft();
        } else if (e.getKeyChar() == 'd') {
            controller.notifyNoMoreMoveRight();
        }
    }

}
