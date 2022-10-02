package it.aren.graphic.component;

import it.aren.model.BaseEntity;
import it.aren.model.Component;
import it.aren.model.Controller;

public class GraphicComponent implements Component {

    @Override
    public <T, C extends Controller<T>>void update(BaseEntity entity, C controller) {
            controller.update((T) entity);
    }
}
