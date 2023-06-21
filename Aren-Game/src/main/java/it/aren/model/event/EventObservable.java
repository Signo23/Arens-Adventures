package it.aren.model.event;

import it.aren.Observable;
import it.aren.common.ApplicationState;

import java.util.LinkedList;
import java.util.List;

/**
 * Create a listener for {@link BaseEvent}.
 */
public abstract class EventObservable implements Observable<BaseEvent> {
    protected final List<BaseEvent> eventList;
    private ApplicationState state;

    protected EventObservable() {
        this.eventList = new LinkedList<>();
        this.state = ApplicationState.BOOT;
    }

    @Override
    /**
     * Notify to the listener an {@link BaseEvent}.
     * @param event {@link BaseEvent} to notify the listener
     */
    public void notify(BaseEvent event){
        this.eventList.add(event);
    }

    public ApplicationState getState(){
        return this.state;
    }
    public void setState(final ApplicationState state){
        this.state = state;
    }
}
