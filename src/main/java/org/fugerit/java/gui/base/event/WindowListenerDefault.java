package org.fugerit.java.gui.base.event;

import org.fugerit.java.core.util.ObjectUtils;
import org.fugerit.java.gui.base.EventContextHandler;
import org.fugerit.java.gui.base.EventContextWrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDefault extends EventContextHandler implements WindowListener {

    public WindowListenerDefault(EventContextWrapper contextWrapper) {
        super(contextWrapper);
    }

    private WindowConsumeEvent openedConsumer;

    private WindowConsumeEvent closedConsumer;

    private WindowConsumeEvent closingConsumer;

    private WindowConsumeEvent iconifiedConsumer;

    private WindowConsumeEvent deiconifiedConsumer;

    private WindowConsumeEvent activatedConsumer;

    private WindowConsumeEvent deactivatedConsumer;


    @Override
    public void windowOpened(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.openedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.closingConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowClosed(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.closedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowIconified(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.iconifiedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.deiconifiedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowActivated(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.activatedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        ObjectUtils.objectWithDefault( this.deactivatedConsumer, WindowConsumeEvent.DEFAULT ).handle( this.getEventContext(), e );
    }

    public WindowListenerDefault withOpenedConsumer(WindowConsumeEvent openedConsumer) {
        this.openedConsumer = openedConsumer;
        return this;
    }

    public WindowListenerDefault withClosedConsumer(WindowConsumeEvent closedConsumer) {
        this.closedConsumer = closedConsumer;
        return this;
    }

    public WindowListenerDefault withClosingConsumer(WindowConsumeEvent closingConsumer) {
        this.closingConsumer = closingConsumer;
        return this;
    }

    public WindowListenerDefault withIconifiedConsumer(WindowConsumeEvent iconifiedConsumer) {
        this.iconifiedConsumer = iconifiedConsumer;
        return this;
    }

    public WindowListenerDefault withDeiconifiedConsumer(WindowConsumeEvent deiconifiedConsumer) {
        this.deiconifiedConsumer = deiconifiedConsumer;
        return this;
    }

    public WindowListenerDefault withActivatedConsumer(WindowConsumeEvent activatedConsumer) {
        this.activatedConsumer = activatedConsumer;
        return this;
    }

    public WindowListenerDefault withDeactivatedConsumer(WindowConsumeEvent deactivatedConsumer) {
        this.deactivatedConsumer = deactivatedConsumer;
        return this;
    }
}
