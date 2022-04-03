/**
 * 
 */
package it.aren.core;

import it.aren.common.Constant;
import it.aren.graphic.SwingView;
import it.aren.graphic.View;

/**
 * 
 *
 */
public class GameEngine {
    private View view;

    public void setup() {
        this.view = new SwingView();
    }

    public void loop() {
        final long current = System.currentTimeMillis();
        this.processInput();
        this.updateGame();
        this.render();
        this.waitNextFrame(current);
    }

    private void processInput() {
        // TODO
    }

    private void updateGame() {
        // TODO updates events
    }

    private void render() {
        this.view.render();
    }

    private void waitNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < Constant.DEFAULT_FPS) {
            try {
                Thread.sleep(Constant.DEFAULT_FPS - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
