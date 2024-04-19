package it.aren.core;

import it.aren.Observable;
import it.aren.common.ApplicationState;
import it.aren.common.Constant;
import it.aren.model.input.MenuInputController;

import static it.aren.common.ApplicationState.BOOT;
import static it.aren.common.ApplicationState.MENU;

/**
 * This class contain the main loop.
 * This is the main controller.
 *
 */
public class GameEngine {
    private final MenuInputController menuController;
    private final Observable<ApplicationState> gameState;

    /**
     * Constructor for GameEngine.
     */
    public GameEngine(final MenuInputController menuController, final Observable<ApplicationState> gameState) {
        super();
        this.menuController = menuController;
        this.gameState = gameState;
    }

    /**
     * Setup the game.
     */
    public void setup() {
        gameState.next(BOOT);
        /*this.notify(new InteractWithPlayerEvent(new GameObject(
                BaseObjectEnum.VOID, new Vector2D(), false, new GraphicComponent()),
                "Trova tutti gli oggetti prima di\npartire per la tua avventura"));*/
    }

    /**
     * The main loop of the game.
     * Call setup() before this.
     */
    public void loop() {
        while (gameState.getState() != ApplicationState.CLOSE) {
            final long current = System.currentTimeMillis();
            switch (gameState.getState()) {
            case BOOT:
                gameState.next(MENU);
                break;
            case MENU:
                if (this.menuController.isInteract()) {
                    this.menuController.notifyNoMoreIsInteract();
                    gameState.next(ApplicationState.GAME);
                }
                if (this.menuController.isSettings()) {
                    this.menuController.notifyNoMoreIsSettings();
                    gameState.next(ApplicationState.MENU_SETTINGS);
                }
                break;
            case MENU_SETTINGS:
                if (this.menuController.isInteract()) {
                    this.menuController.notifyNoMoreIsInteract();
                    gameState.next(MENU);
                }
                break;
            case GAME:
            case GAME_DIALOG:
                    gameState.next(ApplicationState.GAME_DIALOG);
                break;
            default:
                break;
            }
            this.waitNextFrame(current);
        }
    }

    private void waitNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < Constant.DEFAULT_FPS) {
            try {
                Thread.sleep(Constant.DEFAULT_FPS - dt);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
