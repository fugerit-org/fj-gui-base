package org.fugerit.java.gui.base.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.fugerit.java.gui.base.EventContextHandler;
import org.fugerit.java.gui.base.EventContextWrapper;

public class ActionListenerDefault extends EventContextHandler implements ActionListener  {

    public ActionListenerDefault(EventContextWrapper contextWrapper) {
        super(contextWrapper);
        this.actionConsumers = new ArrayList<>();
    }

    private List<ActionConsumeEvent> actionConsumers;

    @Override
    public void actionPerformed(ActionEvent e) {
        for ( ActionConsumeEvent actionConsumeEvent : this.actionConsumers ) {
        	actionConsumeEvent.handle( this.getEventContext() , e );
        }
     }

    public ActionListenerDefault addActionConsumer(ActionConsumeEvent e ) {
    	this.actionConsumers.add( e );
    	return this;
    }
    


}
