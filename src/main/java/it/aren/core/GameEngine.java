/**
 * 
 */
package it.aren.core;

import it.aren.common.Constant;
import it.aren.graphic.SwingView;
import it.aren.graphic.View;
import it.aren.model.GameState;

/**
 * 
 *
 */
public class GameEngine {
    private View view;
    private GameState state;

    public void setup() {
        this.state = new GameState();
        this.view = new SwingView(this.state.getWorld());
    }

    public void loop() {
        final long current = System.currentTimeMillis();
        this.processInput();
        this.updateGame();
        this.render();
        this.waitNextFrame(current);
    }

    private void processInput() {
        //this.state.getWorld().nowMap()
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
