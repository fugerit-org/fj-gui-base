package org.fugerit.java.gui.base.event;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.event.impl.ActionSourceEvent;
import org.fugerit.java.gui.base.event.impl.config.ConfigLoaderEvent;
import org.fugerit.java.gui.base.frame.JMessageFrame;

import javax.swing.*;

public class ConfigEventHelper {

    public static void addConfigStore(BaseFrame frame) {
        // add config menu
        JMenu menuConfig = new JMenu( "Config" );
        // load configuration
        JMenuItem miLoadConfig = (JMenuItem)frame.setUI( new JMenuItem( "Load configuration" ) );
        miLoadConfig.addActionListener( frame );
        menuConfig.add( miLoadConfig );
        frame.getActionListenerDefault().addActionConsumer( new ActionSourceEvent( miLoadConfig, new ConfigLoaderEvent( frame ) ) );
        // save configuration
        JMenuItem miSaveConfig = (JMenuItem)frame.setUI( new JMenuItem( "Save configuration" ) );
        miSaveConfig.addItemListener( frame );
        menuConfig.add( miSaveConfig );
        // message frame
        JMenuItem miLogFrame = (JMenuItem)frame.setUI( new JMenuItem( "Message log" ) );
        miLogFrame.addActionListener( frame );
        menuConfig.add( miLogFrame );
        frame.getActionListenerDefault().addActionConsumer( new ActionSourceEvent( miLogFrame, JMessageFrame.newlogFrameEvent( frame ) ) ) ;
        // menu bare
        JMenuBar menuBar = frame.getJMenuBar();
        if ( menuBar == null ) {
            menuBar = new JMenuBar();
            frame.setJMenuBar( menuBar );
        }
        menuBar.add( menuConfig );
    }

}
