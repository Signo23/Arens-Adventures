package it.aren.model;

public interface Component {
    <T, C extends Controller<T>> void update(Entity entity, C controller);
}
