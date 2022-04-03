package it.aren;

import java.io.File;

import it.aren.common.Constant;
import it.aren.core.GameEngine;

public final class App {
    private App() {
        // the constructor will never be called directly.
    }

    public static void main(final String[] args){
        if (new File(Constant.MAIN_FOLDER).mkdirs()) {
            System.out.println("Directory created succesfully");
        }
        final GameEngine game = new GameEngine();
        game.setup();
        game.loop();
    }
}