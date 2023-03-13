package org.fugerit.java.gui.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumeEventDefault implements ConsumeEvent {

    protected static Logger logger = LoggerFactory.getLogger( ConsumeEvent.class );

    @Override
    public void accept(EventContext t) {
        logger.info( "event consumer : '{}'", this.getClass().getSimpleName() );
    }

}
