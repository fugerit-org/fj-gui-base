package org.fugerit.java.gui.base.event.impl;

import org.fugerit.java.gui.base.EventContext;
import org.fugerit.java.gui.base.event.WindowConsumeEvent;

import java.awt.event.WindowEvent;

public class WindowsExitEvent extends WindowConsumeEvent {

    @Override
    public void handleWorker(EventContext context, WindowEvent e) {
        context.getGuiLogger().info( "{} invoked (System.exit(0))", this.getClass().getSimpleName() );
        System.exit( 0 );
    }

}
