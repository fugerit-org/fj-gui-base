package test.org.fugerit.java.gui.base;

import javax.swing.JLabel;

import org.fugerit.java.gui.base.BaseFrame;
import org.fugerit.java.gui.base.BaseFrameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrameTest extends BaseFrame {

    private static final long serialVersionUID = -6007416897664537268L;
    
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
