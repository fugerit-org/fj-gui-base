package org.fugerit.java.gui.base;

import org.fugerit.java.core.lang.helpers.AttributeHolderDefault;

public class EventContext extends AttributeHolderDefault {

    private static final long serialVersionUID = -7273313831145287786L;

	public EventContext() {
        this.guiLogger = new GUILogger();
    }

    private GUILogger guiLogger;

    public GUILogger getGuiLogger() {
        return guiLogger;
    }

    public void setGuiLogger(GUILogger guiLogger) {
        this.guiLogger = guiLogger;
    }
}
