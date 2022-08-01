package it.aren.graphic.component;

import it.aren.graphic.GraphicController;
import it.aren.model.BaseEntity;
import it.aren.graphic.Component;

public class GraphicComponent implements Component<GraphicController> {
    @Override
    public void update(BaseEntity entity, GraphicController controller) {
        controller.draw(entity);
    }
}
