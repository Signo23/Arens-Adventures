package it.aren.model;

import it.aren.model.BaseEntity;

public interface Component {
    <T, C extends Controller<T>> void update(BaseEntity entity, C controller);
}
