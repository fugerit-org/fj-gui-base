package org.fugerit.java.gui.base;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

import javax.swing.JFrame;

import org.fugerit.java.core.cfg.store.helper.ConfigStoreDefault;
import org.fugerit.java.core.cfg.store.helper.ConfigStoreIO;
import org.fugerit.java.core.util.i18n.BundleMapI18N;
import org.fugerit.java.core.util.i18n.HelperI18N;
import org.fugerit.java.gui.base.event.ActionListenerDefault;
import org.fugerit.java.gui.base.event.ItemListenerDefault;
import org.fugerit.java.gui.base.event.WindowListenerDefault;
import org.fugerit.java.gui.base.event.impl.config.ConfigStoreHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseFrame extends JFrame implements WindowListener, ActionListener, ItemListener, ConfigStoreHelper {

	private static final long serialVersionUID = 90544453453L;

	private static final Logger logger = LoggerFactory.getLogger( BaseFrame.class );
	
	/**
	 * UI customization.
	 *
	 * This method should be invoked on any new component to have a common layout
	 *
	 * @param c	the component to customize
	 * @return	the customized component
	 */
	public <T extends Component> T setUI( T c ) {
		return c;
	}

	private HelperI18N helperI18NCore;
	
	private Locale language;
	
	private ConfigStoreIO configStoreIO;

	private ConfigStoreDefault configStore;

	private ActionListenerDefault actionListener;

	private ItemListenerDefault itemListener;

	private WindowListenerDefault windowListener;

	private EventContextWrapper contextWrapper;

	public BaseFrame( String title, String appId ) {
		this( title, appId, new EventContext() );
	}

	public BaseFrame( String title, String appId, EventContext context ) {
		super( title );
		this.contextWrapper = new EventContextWrapper( context );
		this.configStoreIO = new ConfigStoreIO( appId );
		this.configStore = this.configStoreIO.loadConfig();
		this.actionListener = new ActionListenerDefault(this.contextWrapper);
		this.itemListener = new ItemListenerDefault(this.contextWrapper);
		this.windowListener = new WindowListenerDefault(this.contextWrapper);
		this.language = Locale.getDefault();
		Locale defLoc = Locale.ENGLISH;
		logger.info( "locale {}, def locale {}", this.language.getLanguage(), defLoc.getLanguage() );
		this.helperI18NCore = BundleMapI18N.newHelperI18N( "gui-base-i18n.label-gui-core", defLoc.getLanguage(), this.language.getLanguage() );
	}

	public String getCoreLabel( String key ) {
		return this.helperI18NCore.getString( this.language.getLanguage() , key );
	}

	public EventContext getContext() {
		return this.contextWrapper.getContext();
	}

	public void setContext( EventContext context ) {
		this.contextWrapper.setContext( context );
	}

	public ActionListenerDefault getActionListenerDefault() {
		return actionListener;
	}

	public ItemListenerDefault getItemListenerDefault() {
		return itemListener;
	}

	public WindowListenerDefault getWindowListenerDefault() {
		return windowListener;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		windowListener.windowOpened(e);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		windowListener.windowClosing(e);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		windowListener.windowClosed(e);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		windowListener.windowIconified(e);
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		windowListener.windowDeiconified(e);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		windowListener.windowActivated(e);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		windowListener.windowDeactivated(e);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		actionListener.actionPerformed(e);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.itemListener.itemStateChanged(e);
	}


	public ConfigStoreIO getConfigStoreIO() {
		return configStoreIO;
	}

	public ConfigStoreDefault getConfigStore() {
		return configStore;
	}

	public void setConfigStore(ConfigStoreDefault configStore) {
		this.configStore = configStore;
	}

}
