package it.aren;

import java.util.HashSet;
import java.util.Set;

public class Observable<T> {
    private T state;
    private final Set<Observer<T>> observers;

    public Observable() {
        this.observers = new HashSet<>();
    }

    public void next(T state){
        this.state = state;
        this.observers.forEach(observer -> observer.update(getState()));
    }

    public T getState(){
        return this.state;
    }

    public void attach(final Observer<T> observer) {
        this.observers.add(observer);
    }

    public void detach(final Observer<T> observer) {
        this.observers.remove(observer);
    }

}
