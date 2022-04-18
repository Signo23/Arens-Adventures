/**
 * 
 */
package it.aren.event;

/**
 * Create a listener for {@link Event}.
 */
public interface EventListener {
    /**
     * Notify to the listener an {@link Event}.
     * @param event {@link Event} to send to the listener
     */
    void notifyEvent(Event event);
}
