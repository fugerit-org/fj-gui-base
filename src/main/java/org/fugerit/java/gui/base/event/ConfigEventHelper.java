package org.fugerit.java.gui.base.event;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.EventAddHelper;
import org.fugerit.java.gui.base.event.impl.ActionSourceEvent;
import org.fugerit.java.gui.base.event.impl.config.ConfigLoaderEvent;
import org.fugerit.java.gui.base.event.impl.config.ConfigSaverEvent;
import org.fugerit.java.gui.base.frame.JMessageFrame;

public class ConfigEventHelper extends EventAddHelper {

    public static void addConfigStore(BaseFrame frame) {
        // add config menu
        JMenu menuConfig = new JMenu( frame.getCoreLabel( "config.menu.title" ) );
        // load configuration
        JMenuItem miLoadConfig = new JMenuItem( frame.getCoreLabel( "config.menu.mi.load" ) );
        menuConfig.add( setup( miLoadConfig , frame, new ActionSourceEvent( miLoadConfig, new ConfigLoaderEvent( frame ) ) ) );
        // save configuration
        JMenuItem miSaveConfig = new JMenuItem( frame.getCoreLabel( "config.menu.mi.save" ) );
        menuConfig.add( setup( miSaveConfig, frame, new ActionSourceEvent( miSaveConfig, new ConfigSaverEvent( frame ) ) ) );
        // message frame
        JMenuItem miLogFrame = new JMenuItem( frame.getCoreLabel( "config.menu.mi.log" ) );
        menuConfig.add( setup( miLogFrame, frame, new ActionSourceEvent( miLogFrame, JMessageFrame.newlogFrameEvent( frame ) ) ) );
        // menu bare
        JMenuBar menuBar = getOrCreateJMenuBar( frame );
        menuBar.add( menuConfig );
    }

}
