package it.aren.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import it.aren.common.Constant;
import it.aren.common.Settings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.aren.model.FileSaver;

/**
 * The file saver for settings.
 * Implements {@link FileSave}
 */
public class SettingsSaver implements FileSaver<Settings> {

    private static Gson gson;

    /**
     * Method to write a file.
     * @param objToSave for the object to save
     * @param fileName for the file's name.
     */
    @Override
    public void saveFile(final Settings objToSave, final String fileName) {
        try (Writer writer = new FileWriter(Constant.MAIN_FOLDER + Constant.SEP + fileName)) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(objToSave, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
