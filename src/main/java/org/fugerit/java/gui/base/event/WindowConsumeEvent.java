package org.fugerit.java.gui.base.event;

import org.fugerit.java.gui.base.ConsumeEventDefault;
import org.fugerit.java.gui.base.EventContext;

import java.awt.event.WindowEvent;

public abstract class WindowConsumeEvent extends ConsumeEventDefault {

    public static final WindowConsumeEvent DEFAULT = new WindowConsumeEvent() {
        @Override
        public void handleWorker(EventContext context, WindowEvent e) {

        }
        @Override
        public WindowConsumeEvent addBefore(WindowConsumeEvent before) {
            if ( Boolean.TRUE ) {
                throw new UnsupportedOperationException( "Cannot modify default event handler" );
            }
            return null;
        }
    };

    public static WindowConsumeEvent newDoNothing() {
        WindowConsumeEvent windowConsumeEvent = new WindowConsumeEvent() {
            @Override
            public void handleWorker(EventContext context, WindowEvent e) {
            }
        };
        return windowConsumeEvent;
    }

    private WindowConsumeEvent before;

    public void handle(EventContext context, WindowEvent e) {
        logger.info( "executing event handler {}", this.getClass().getSimpleName() );
        if ( this.before != null ) {
            this.before.handle( context, e );
        }
        this.handleWorker( context, e );
    }

    public abstract void handleWorker( EventContext context, WindowEvent e );

    public WindowConsumeEvent getBefore() {
        return before;
    }

    public WindowConsumeEvent addBefore(WindowConsumeEvent before) {
        this.before = before;
        return this;
    }

}

