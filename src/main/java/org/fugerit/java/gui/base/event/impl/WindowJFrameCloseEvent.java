package org.fugerit.java.gui.base.event.impl;

import org.fugerit.java.gui.base.EventContext;
import org.fugerit.java.gui.base.event.WindowConsumeEvent;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class WindowJFrameCloseEvent extends WindowConsumeEvent  {

    public WindowJFrameCloseEvent(JFrame frame) {
        this.frame = frame;
    }

    private JFrame frame;

    @Override
    public void handleWorker(EventContext context, WindowEvent e) {
        context.getGuiLogger().info( "{} invoked", this.getClass().getSimpleName() );
        this.frame.setVisible( false );
    }
}
