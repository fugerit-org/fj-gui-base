package org.fugerit.java.gui.base.event.impl.config;

import org.fugerit.java.gui.base.ConsumeEventDefault;
import org.fugerit.java.gui.base.EventContext;

public class ConfigSaverEvent extends ConsumeEventDefault {

    public ConfigSaverEvent(ConfigStoreHelper configStoreHelper) {
        this.configStoreHelper = configStoreHelper;
    }

    private ConfigStoreHelper configStoreHelper;

    @Override
    public void accept(EventContext t) {
        super.accept(t);
        try {
            t.getGuiLogger().info( "{} - Saving configuration...", this.getClass().getSimpleName() );
            this.configStoreHelper.getConfigStoreIO().saveConfig( this.configStoreHelper.getConfigStore() );
            t.getGuiLogger().info( "{} - ... config saved", this.getClass().getSimpleName() );
        } catch (Exception e) {
            t.getGuiLogger().error( "Error loading configuration "+e, e );
        }
    }
    
}
