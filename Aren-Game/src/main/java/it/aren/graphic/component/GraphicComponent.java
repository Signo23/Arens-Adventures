package it.aren.graphic.component;

import it.aren.Entity;
import it.aren.Command;
import it.aren.Controller;

public class GraphicComponent implements Command {

    @Override
    public <T, C extends Controller<T>>void update(Entity entity, C controller) {
            controller.update((T) entity);
    }
}
