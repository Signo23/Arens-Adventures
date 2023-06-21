package it.aren.core;

import java.util.HashSet;
import java.util.Set;

import it.aren.Observer;
import it.aren.common.ApplicationState;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Constant;
import it.aren.geom.Vector2D;
import it.aren.model.event.EventObservable;
import it.aren.model.event.InteractWithPlayerEvent;
import it.aren.graphic.component.GraphicComponent;
import it.aren.model.input.MenuInputController;
import it.aren.model.game.GameObject;

/**
 * This class contain the main loop.
 * This is the main controller.
 * Implements {@link EventObservable}
 *
 */
public class GameEngine extends EventObservable {
    private final Set<Observer> observers;
    private final MenuInputController menuController;

    /**
     * Constructor for GameEngine.
     */
    public GameEngine(final MenuInputController menuController) {
        this.menuController = menuController;
        this.observers = new HashSet<>();
    }

    /**
     * Setup the game.
     */
    public void setup() {
        this.notify(new InteractWithPlayerEvent(new GameObject(
                BaseObjectEnum.VOID, new Vector2D(), false, new GraphicComponent()),
                "Trova tutti gli oggetti prima di\npartire per la tua avventura"));
    }

    /**
     * The main loop of the game.
     * Call setup() before this.
     */
    public void loop() {
        while (true) {
            final long current = System.currentTimeMillis();
            switch (this.getState()) {
            case BOOT:
                this.changeStates(ApplicationState.MENU);
                break;
            case MENU:
                if (this.menuController.isInteract()) {
                    this.menuController.notifyNoMoreIsInteract();
                    this.changeStates(ApplicationState.GAME);
                }
                if (this.menuController.isSettings()) {
                    this.menuController.notifyNoMoreIsSettings();
                    this.changeStates(ApplicationState.MENU_SETTINGS);
                }
                this.updateGame();
                break;
            case MENU_SETTINGS:
                if (this.menuController.isInteract()) {
                    this.menuController.notifyNoMoreIsInteract();
                    this.changeStates(ApplicationState.MENU);
                }
                break;
            case GAME:
            case GAME_DIALOG:
                    this.updateGame();
                break;
            default:
                break;
            }
            this.waitNextFrame(current);
        }
    }

    private void changeStates(final ApplicationState newState) {
        this.setState(newState);
    }
    private void updateGame() {
        this.observers.forEach(Observer::update);
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

    @Override
    public void attach(final Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(final Observer observer) {
        this.observers.remove(observer);
    }
}
