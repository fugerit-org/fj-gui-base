package org.fugerit.java.gui.base.event.impl;

import org.fugerit.java.gui.base.ConsumeEvent;
import org.fugerit.java.gui.base.EventContext;
import org.fugerit.java.gui.base.event.ActionConsumeEvent;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionSourceEvent extends ActionConsumeEvent {

    public ActionSourceEvent(Component source, ConsumeEvent consumer) {
        this.source = source;
        this.consumer = consumer;
    }

    private Component source;

    private ConsumeEvent consumer;

    @Override
    public void handleWorker(EventContext context, ActionEvent e) {
    	boolean testResult = (e.getSource() == this.source);
    	context.getGuiLogger().info( "{} is current source? {}", this.getClass().getSimpleName(), testResult );
        if ( testResult ) {
            context.getGuiLogger().info( "{} invoked for {}", this.getClass().getSimpleName(), this.source );
            this.consumer.accept( context );
        }
    }

}
