package it.aren.file;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import it.aren.common.PointRange;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.aren.model.FileLoader;

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
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(this.getClass()
                .getResourceAsStream("/" + fileName)))) {
            final Type type = new TypeToken<Map<String, List<PointRange>>>() { }.getType();
            final Gson gson = new GsonBuilder().setPrettyPrinting().create();
            final Map<String, List<PointRange>> set = gson.fromJson(reader, type);
            reader.close();
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

}
