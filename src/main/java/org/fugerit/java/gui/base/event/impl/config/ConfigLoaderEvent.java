package org.fugerit.java.gui.base.event.impl.config;

import org.fugerit.java.gui.base.ConsumeEventDefault;
import org.fugerit.java.gui.base.EventContext;

public class ConfigLoaderEvent extends ConsumeEventDefault {

    public ConfigLoaderEvent(ConfigStoreHelper configStoreHelper) {
        this.configStoreHelper = configStoreHelper;
    }

    private ConfigStoreHelper configStoreHelper;

    @Override
    public void accept(EventContext t) {
        super.accept(t);
        try {
            t.getGuiLogger().info( "{} - Loading configuration...", this.getClass().getSimpleName() );
            this.configStoreHelper.setConfigStore( this.configStoreHelper.getConfigStoreIO().loadConfig() );
            t.getGuiLogger().info( "{} - ... config loaded", this.getClass().getSimpleName() );
        } catch (Exception e) {
            t.getGuiLogger().error( "Error loading configuration "+e, e );
        }
    }
}
