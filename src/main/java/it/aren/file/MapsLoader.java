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

public class MapsLoader implements FileLoader<Map<String, List<PointRange>>> {

    private Gson gson;

    @Override
    public final Map<String, List<PointRange>> loadFile(final String fileName) {
        try (Reader reader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/" + fileName))) {
            final Type type = new TypeToken<Map<String, List<PointRange>>>() { }.getType();
            this.gson = new GsonBuilder().setPrettyPrinting().create();
            final Map<String, List<PointRange>> set = gson.fromJson(reader, type);
            reader.close();
            System.out.println(set);
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<String, List<PointRange>>();
    }

    public static Map<String, List<PointRange>> loadMaps(final String fileName) {
        final MapsLoader loader = new MapsLoader();
        return loader.loadFile(fileName);
    }

}