package org.fugerit.java.gui.base;

import org.fugerit.java.gui.base.event.ConfigEventHelper;
import org.fugerit.java.gui.base.event.WindowEventHelper;

public class BaseFrameHelper {

    public static void setupDefaultBehaviour( BaseFrame frame ) {
        ConfigEventHelper.addConfigStore(frame);
        WindowEventHelper.addDefaultWindowClosingBehaviour(frame);
    }

}
