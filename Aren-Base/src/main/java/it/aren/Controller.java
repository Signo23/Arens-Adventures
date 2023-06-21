package it.aren;

public interface Controller<T, K> {

    void update(T toUpdate, K value);
}
