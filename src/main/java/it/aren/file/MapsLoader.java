package it.aren.file;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import it.aren.common.PointRange;

/**
 * The loader for the game map's blocks.
 * Implements {@link FileLoader}
 *
 */
public class MapsLoader implements FileLoader<Map<String, List<PointRange>>> {

    /**
     * {@inheritDoc}
     */
    @Override
    public final Map<String, List<PointRange>> loadFile(final String fileName) {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/" + fileName))) {
            final Type type = new TypeToken<Map<String, List<PointRange>>>() { }.getType();
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            final Map<String, List<PointRange>> set = gson.fromJson(reader, type);
            reader.close();
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<String, List<PointRange>>();
    }

    /**
     * Create a {@link MapsLoader} by the file's name.
     * @param fileName the file's name to load
     * @return the loaded file
     */
    public static Map<String, List<PointRange>> loadMaps(final String fileName) {
        final MapsLoader loader = new MapsLoader();
        return loader.loadFile(fileName);
    }

}
