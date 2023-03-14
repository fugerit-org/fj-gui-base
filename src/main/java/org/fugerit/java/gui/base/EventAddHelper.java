package org.fugerit.java.gui.base;

import javax.swing.AbstractButton;
import javax.swing.JMenuBar;

import org.fugerit.java.gui.base.event.ActionConsumeEvent;

public class EventAddHelper {

	public static JMenuBar getOrCreateJMenuBar( BaseFrame frame ) {
		JMenuBar menuBar = frame.getJMenuBar();
        if ( menuBar == null ) {
            menuBar = new JMenuBar();
            frame.setJMenuBar( menuBar );
        }
        return menuBar;
	}
	
	public static <T extends AbstractButton> T setup( T c, BaseFrame frame, ActionConsumeEvent e ) {
		frame.setUI( c );
		c.addActionListener( frame );
		frame.getActionListenerDefault().addActionConsumer( e );
		return c;
	}
	
}
