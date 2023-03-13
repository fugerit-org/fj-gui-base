package org.fugerit.java.gui.base.event.impl;

import org.fugerit.java.gui.base.ConsumeEvent;
import org.fugerit.java.gui.base.EventContext;
import org.fugerit.java.gui.base.event.ItemConsumeEvent;

import java.awt.*;
import java.awt.event.ItemEvent;

public class ItemSourceEvent extends ItemConsumeEvent {

    public ItemSourceEvent(Component source, ConsumeEvent consumer) {
        this.source = source;
        this.consumer = consumer;
    }

    private Component source;

    private ConsumeEvent consumer;

    @Override
    public void handleWorker(EventContext context, ItemEvent e) {
        if ( e.getSource() == this.source ) {
            context.getGuiLogger().logMessage( "{} invoked for {}", this.getClass().getSimpleName(), this.source );
            this.consumer.accept( context );
        }
    }

}
