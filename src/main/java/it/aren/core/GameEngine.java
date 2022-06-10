/**
 * 
 */
package it.aren.core;

import java.util.LinkedList;
import java.util.List;

import it.aren.common.ApplicationState;
import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.event.Event;
import it.aren.event.EventListener;
import it.aren.file.SettingsLoader;
import it.aren.graphic.SwingView;
import it.aren.graphic.View;
import it.aren.input.InputController;
import it.aren.input.KeyboardInputController;
import it.aren.model.GameState;

/**
 * This class contain the main loop.
 * This is the main controller.
 * Implements {@link EventListener}
 *
 */
public class GameEngine implements EventListener {
    private View view;
    private GameState state;
    private InputController controller;

    private final List<Event> eventList;

    /**
     * Constructor for GameEngine.
     */
    public GameEngine() {
        this.eventList = new LinkedList<>();
    }

    /**
     * Setup the game.
     */
    public void setup() {
        final Settings settings = SettingsLoader.loadSettings();
        this.state = new GameState(this);
        this.controller = new KeyboardInputController();
        this.view = new SwingView(this.state.getWorld(), this.controller, settings);
    }

    /**
     * The main loop of the game.
     * Call {@link setup()} before this.
     */
    public void loop() {
        while (true) {
            final long current = System.currentTimeMillis();
            switch (this.state.getState()) {
            case BOOT:
                this.state.setState(ApplicationState.GAME);
                break;
            case GAME:
                this.processInput();
                this.updateGame();
                this.render();
                break;
            case GAME_DIALOG:
                this.updateHUD();
                this.render();
                break;
            default:
                break;
            }
            this.waitNextFrame(current);
        }
    }

    private void processInput() {
        this.state.processInput(this.controller);
    }

    private void updateGame() {
        this.state.update();
        this.launchEvent();
    }

    private void launchEvent() {
        this.eventList.stream().forEach(e -> e.launch(this.state));
        this.eventList.clear();
    }

    private void render() {
        this.view.render();
    }

    private void updateHUD() {
        if (this.controller.isOnClose()) {
            this.state.getWorld().setDialog(null);
            this.state.setState(ApplicationState.GAME);
        }
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


    /**
     * {@inheritDoc}
     */
    @Override
    public final void notifyEvent(final Event event) {
        this.eventList.add(event);
    }
}
