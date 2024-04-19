package it.aren.file;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import it.aren.common.Constant;
import it.aren.common.Settings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.aren.core.GameFactory;
import it.aren.io.FileLoader;

/**
 * The file loader for settings.
 * Implements {@link FileLoader}
 */
public class SettingsLoader implements FileLoader<Settings> {

    private static Settings settings;
    private static SettingsLoader settingsLoader;

    private SettingsLoader() {}

    public static SettingsLoader getSettingsLoader(){
        if(settingsLoader == null){
            settingsLoader = new SettingsLoader();
        }
        return settingsLoader;
    }

    /**
     * Method to load a file.
     * @param fileName for the file's name.
     * @return {@link Settings}
     */
    @Override
    public Settings loadFile(final String fileName) {
        if(settings == null) {
            try (Reader reader = Files.newBufferedReader(Paths.get(Constant.MAIN_FOLDER + Constant.SEP + fileName))) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                settings = gson.fromJson(reader, Settings.class);
            } catch (IOException e) {
                settings = new Settings();
                GameFactory.saveSettings(settings);
            }
        }
        return settings;
    }
}