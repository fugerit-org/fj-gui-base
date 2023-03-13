package test.org.fugerit.java.gui.base;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.BaseFrameHelper;
import org.fugerit.java.gui.base.EventContext;
import org.fugerit.java.gui.base.event.WindowConsumeEvent;
import org.fugerit.java.gui.base.event.WindowEventHelper;
import org.fugerit.java.gui.base.event.impl.WindowJFrameCloseEvent;
import org.fugerit.java.gui.base.event.impl.WindowsExitEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class FrameTest extends BaseFrame {

    private static final Logger logger = LoggerFactory.getLogger( FrameTest.class );

    public FrameTest() {
        super( "Test GUI","test-gui"  );

        BaseFrameHelper.setupDefaultBehaviour(this);

        this.add( new JLabel( "Test app" ) );

        // windows closing handler


        this.setResizable(true);
        this.setSize(800, 600);
        this.setVisible(true);
        logger.info( "test" );
    }
}
