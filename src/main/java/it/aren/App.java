package it.aren;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import it.aren.common.ApplicationState;
import it.aren.common.Constant;
import it.aren.core.GameEngine;
import it.aren.graphic.AppView;
import it.aren.model.GameState;
import it.aren.model.input.InputController;
import it.aren.model.input.KeyboardInputController;
import it.aren.model.input.MenuInputController;

/**
 * The main class of the game. This starts the game
 *
 */
public final class App {
    private App() {
        // the constructor will never be called directly.
    }

    /**
     * Method to restart the game.
     *
     */
    public static void restart() {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        File currentJar;
        try {
            currentJar = new File(App.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            if (!currentJar.getName().endsWith(".jar")) {
                return;
            }

            final List<String> command = new ArrayList<>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0); //NOPMD: this is the only method we found for restart the application
        } catch (URISyntaxException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

    }

    /**
     * The main function creates a new folder called ".aren" and then creates a new game engine object
     * and calls the setup and loop functions.
     * 
     * @param args The arguments passed to the program.
     */
    public static void main(final String[] args) {
        if (new File(Constant.MAIN_FOLDER).mkdirs()) {
            System.out.println("Directory created successfully");
        }
        final InputController inputController = new KeyboardInputController();
        final MenuInputController menuController = new MenuInputController();
        final GameState gameState = new GameState(inputController);
        final GameEngine game = new GameEngine(menuController, gameState);
        final AppView view = new AppView(gameState.getWorld(), inputController, menuController);
        gameState.attach(view);
        game.setup();
        game.loop();
        System.exit(0);
    }
}
