package org.fugerit.java.gui.base.event;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.event.impl.WindowJFrameCloseEvent;
import org.fugerit.java.gui.base.event.impl.WindowsExitEvent;

public class WindowEventHelper {

    public static void addDefaultWindowClosingBehaviour(BaseFrame frame) {
        WindowConsumeEvent closeEvent = new WindowsExitEvent().addBefore( new WindowJFrameCloseEvent( frame ) );
        frame.getWindowListenerDefault().withClosedConsumer( closeEvent ).withClosingConsumer( closeEvent );
        frame.addWindowListener( frame );
    }

}
