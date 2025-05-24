package todav.core;

import todav.core.configuration.ConfigurationManager;

public class TodavCore {
    public TodavClient initializeDefault() {
        ConfigurationManager configManager = getConfigManager();
        return new TodavClient();
    }

    private ConfigurationManager getConfigManager() {
        return null;
    }
}
