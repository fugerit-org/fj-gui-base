package org.fugerit.java.gui.base.event.impl.config;

import org.fugerit.java.core.cfg.store.helper.ConfigStoreDefault;
import org.fugerit.java.core.cfg.store.helper.ConfigStoreIO;

public interface ConfigStoreHelper {

    ConfigStoreIO getConfigStoreIO();

    ConfigStoreDefault getConfigStore();
    void setConfigStore(ConfigStoreDefault configStore);

}
