package it.aren;

public interface Command {
    <T, C extends Controller<T, K>, K> void update(Entity entity, C controller, K value);
}
