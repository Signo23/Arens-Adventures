package it.aren;

public interface Observer<T> {
    void update(T newState);
}
