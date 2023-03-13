package test.org.fugerit.java.gui.base;

import org.fugerit.java.gui.base.BaseFrame;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBaseFrame {

    private static final Logger logger = LoggerFactory.getLogger( TestBaseFrame.class );

    @Test
    public void testBaseFrame() {
        main( null );
    }

    public static void main( String[] args ) {
        FrameTest gui = new FrameTest();
        logger.info( "test frame {}", gui );
    }

}
