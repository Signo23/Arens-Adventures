package it.aren.file;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import it.aren.common.Constant;
import it.aren.common.Settings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.aren.model.FileLoader;

/**
 * The file loader for settings.
 * Implements {@link FileLoader}
 */
public class SettingsLoader implements FileLoader<Settings> {

    private static Gson gson;

    /**
     * Method to load a file.
     * @param fileName for the file's name.
     * @return {@link Settings}
     */
    @Override
    public Settings loadFile(final String fileName) {
        try (Reader reader = Files.newBufferedReader(Paths.get(Constant.MAIN_FOLDER + Constant.SEP + fileName))) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            final Settings set = gson.fromJson(reader, Settings.class);
            reader.close();
            return set;
        } catch (IOException e) {
            final Settings set = new Settings();
            final SettingsSaver settingsSaver = new SettingsSaver();
            settingsSaver.saveFile(set, Constant.SETTINGS_FILE);
            return set;
        }
    }
}