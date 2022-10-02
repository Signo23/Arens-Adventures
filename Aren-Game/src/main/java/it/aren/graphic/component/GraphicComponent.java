package it.aren.graphic.component;

import it.aren.Entity;
import it.aren.Component;
import it.aren.Controller;

public class GraphicComponent implements Component {

    @Override
    public <T, C extends Controller<T>>void update(Entity entity, C controller) {
            controller.update((T) entity);
    }
}
