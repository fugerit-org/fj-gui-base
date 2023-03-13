package org.fugerit.java.gui.base.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import org.fugerit.java.gui.base.EventContextHandler;
import org.fugerit.java.gui.base.EventContextWrapper;

public class ItemListenerDefault extends EventContextHandler implements ItemListener {

    public ItemListenerDefault(EventContextWrapper contextWrapper) {
        super(contextWrapper);
    }

    private List<ItemConsumeEvent> itemConsumers;

    @Override
    public void itemStateChanged(ItemEvent e) {
    	for ( ItemConsumeEvent itemConsumeEvent : this.itemConsumers ) {
    		itemConsumeEvent.handle( this.getEventContext() , e );
    	}
    }

    public ItemListenerDefault addItemConsumer( ItemConsumeEvent e ) {
        this.itemConsumers.add( e );
        return this;
    }

}
