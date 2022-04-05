package it.aren.graphic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import it.aren.common.Constant;
import it.aren.input.KeyboardInputController;

public class KeyListenerImpl implements KeyListener {

    private final KeyboardInputController controller;

    public KeyListenerImpl(final KeyboardInputController controller) {
        this.controller = controller;
    }

    @Override
    public final void keyTyped(final KeyEvent e) {
        if (e.getKeyCode() == Constant.VK_W) {
            controller.notifyMoveUp();
        } else if (e.getKeyCode() == Constant.VK_S) {
            controller.notifyMoveDown();
        } else if (e.getKeyCode() == Constant.VK_A) {
            controller.notifyMoveLeft();
        } else if (e.getKeyCode() == Constant.VK_D) {
            controller.notifyMoveRight();
        }
    }

    @Override
    public void keyPressed(final KeyEvent e) { }

    @Override
    public final void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == Constant.VK_W) {
            controller.notifyNoMoreMoveUp();
        } else if (e.getKeyCode() == Constant.VK_S) {
            controller.notifyNoMoreMoveDown();
        } else if (e.getKeyCode() == Constant.VK_A) {
            controller.notifyNoMoreMoveLeft();
        } else if (e.getKeyCode() == Constant.VK_D) {
            controller.notifyNoMoreMoveRight();
        }
    }

}
