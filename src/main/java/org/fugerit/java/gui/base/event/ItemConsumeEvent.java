package org.fugerit.java.gui.base.event;

import org.fugerit.java.gui.base.ConsumeEventDefault;
import org.fugerit.java.gui.base.EventContext;

import java.awt.event.ItemEvent;

public abstract class ItemConsumeEvent extends ConsumeEventDefault {

    public final static ItemConsumeEvent DEFAULT = new ItemConsumeEvent() {
        @Override
        public void handleWorker(EventContext context, ItemEvent e) {

        }
    };
    
    public void handle(EventContext context, ItemEvent e) {
        logger.info( "executing event handler {}", this.getClass().getSimpleName() );
        this.handleWorker( context, e );
    }

    public abstract void handleWorker(EventContext context, ItemEvent e);

}

