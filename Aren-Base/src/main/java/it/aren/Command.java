package it.aren;

public interface Command {
    <T, C extends Controller<T>> void update(Entity entity, C controller);
}
