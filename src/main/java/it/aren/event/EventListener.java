package it.aren.event;

/**
 * Create a listener for {@link BaseEvent}.
 */
public interface EventListener {
    /**
     * Notify to the listener an {@link BaseEvent}.
     * @param event {@link BaseEvent} to notify the listener
     */
    void notifyEvent(BaseEvent event);
}
