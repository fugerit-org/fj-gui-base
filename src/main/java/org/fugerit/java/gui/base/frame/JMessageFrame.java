package org.fugerit.java.gui.base.frame;

import java.awt.BorderLayout;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.ConsumeEvent;
import org.fugerit.java.gui.base.EventContext;

public class JMessageFrame extends JFrame {

    private static final long serialVersionUID = 4576316101356083126L;

	public static ConsumeEvent newlogFrameEvent( BaseFrame frame ) {
        return new ConsumeEvent() {
            private JMessageFrame messageFrame = new JMessageFrame( frame );
            @Override
            public void accept(EventContext eventContext) {
                messageFrame.setVisible( true );
            }
        };
    }

    public JMessageFrame( BaseFrame frame ) {
        super( "log frame" );
        this.setSize( 640, 480 );
        this.setLayout( new BorderLayout() );
        JTextArea logArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(logArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add( scroll, BorderLayout.CENTER );
        frame.getContext().getGuiLogger().setConsumeLog( new Consumer<String>() {	
			@Override
			public void accept(String t) {
				logArea.append( t );
			}
		} );
    }

}
