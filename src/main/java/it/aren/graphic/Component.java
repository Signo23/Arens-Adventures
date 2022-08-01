package it.aren.graphic;

import it.aren.model.BaseEntity;

public interface Component<C> {
    void update(BaseEntity entity, C controller);
}
