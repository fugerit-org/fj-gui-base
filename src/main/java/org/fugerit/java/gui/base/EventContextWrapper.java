package org.fugerit.java.gui.base;

public class EventContextWrapper {

    public EventContextWrapper(EventContext context) {
        this.context = context;
    }

    private EventContext context;

    public EventContext getContext() {
        return context;
    }

    public void setContext(EventContext context) {
        this.context = context;
    }
}
