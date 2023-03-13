package org.fugerit.java.gui.base;

public class EventContextHandler {

    private EventContextWrapper contextWrapper;

    public EventContextHandler(EventContextWrapper contextWrapper) {
        this.contextWrapper = contextWrapper;
    }

    public EventContext getEventContext() {
        return contextWrapper.getContext();
    }

}
