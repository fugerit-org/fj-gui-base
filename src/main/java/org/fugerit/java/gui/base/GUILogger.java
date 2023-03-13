package org.fugerit.java.gui.base;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUILogger {

    private static final Logger logger = LoggerFactory.getLogger( GUILogger.class );

    private Consumer<String> consumeLog = new Consumer<String>() {
		@Override
		public void accept(String t) {
		}
    };
    
    public void setConsumeLog(Consumer<String> consumeLog) {
		this.consumeLog = consumeLog;
	}

	public void logMessage( String message, Object... params ) {
		String fullMessage = String.format( message.replace( "{}" , "%s" ) , params );
    	consumeLog.accept( fullMessage+"\n" );
    }

    public void logException( Exception e  ) {
    }

    public void error( String message, Exception e ) {
        logger.info( message, e );
        this.logMessage( "[ERROR]"+message );
        this.logException( e );
    }

    public void warn( String message, Object... params ) {
        logger.info( message, params );
        this.logMessage( "[WARN]"+message, params );
    }

    public void info( String message, Object... params ) {
        logger.info( message, params );
        this.logMessage( "[INFO]"+message, params );
    }

}
