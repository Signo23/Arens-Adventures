package it.aren;

public interface Observable<T> {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(T event);

}
