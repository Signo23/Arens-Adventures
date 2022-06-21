package it.aren.core;

import java.util.LinkedList;
import java.util.List;

import it.aren.common.ApplicationState;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.event.BaseEvent;
import it.aren.event.EventListener;
import it.aren.event.InteractWithPlayerEvent;
import it.aren.graphic.AppView;
import it.aren.graphic.BaseView;
import it.aren.graphic.component.GameObjectGraphicComponent;
import it.aren.input.InputController;
import it.aren.input.KeyboardInputController;
import it.aren.input.MenuInputController;
import it.aren.model.GameState;
import it.aren.model.game.GameObject;

/**
 * This class contain the main loop.
 * This is the main controller.
 * Implements {@link EventListener}
 *
 */
public class GameEngine implements EventListener {
    private BaseView view;
    private GameState state;
    private InputController controller;
    private MenuInputController menuController;

    private final List<BaseEvent> eventList;

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
        this.state = new GameState(this);
        this.controller = new KeyboardInputController();
        this.menuController = new MenuInputController();
        this.view = new AppView(this.state.getWorld(), this.controller, this.menuController);
        this.notifyEvent(new InteractWithPlayerEvent(new GameObject(
                BaseObjectEnum.VOID, new Point2D(), false, new GameObjectGraphicComponent()),
                "Trova tutti gli oggetti prima di\npartire per la tua avventura"));
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
                this.render();
                break;
            case MENU_SETTINGS:
                if (this.menuController.isInteract()) {
                    this.menuController.notifyNoMoreIsInteract();
                    this.changeStates(ApplicationState.MENU);
                }
                this.render();
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

    private void changeStates(final ApplicationState newState) {
        this.state.setState(newState);
        this.view.changeState(newState);
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
    public final void notifyEvent(final BaseEvent event) {
        this.eventList.add(event);
    }
}
