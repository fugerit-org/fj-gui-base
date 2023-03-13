package org.fugerit.java.gui.base.event;

import java.awt.event.ActionEvent;

import org.fugerit.java.gui.base.ConsumeEventDefault;
import org.fugerit.java.gui.base.EventContext;

public abstract class ActionConsumeEvent extends ConsumeEventDefault {

    public final static ActionConsumeEvent DEFAULT = new ActionConsumeEvent() {
        @Override
        public void handleWorker(EventContext context, ActionEvent e) {

        }
    };

    public void handle(EventContext context, ActionEvent e) {
        logger.info( "executing event handler : {}", this.getClass().getName() );
        this.handleWorker( context, e );
    }

    public abstract void handleWorker(EventContext context, ActionEvent e);


}

