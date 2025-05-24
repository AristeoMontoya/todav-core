package todav.core;

import todav.core.client.TodavClient;
import todav.core.client.TodavClientBuilder;
import todav.core.configuration.ConfigurationManager;

public class TodavCore {
    public TodavClient initializeDefault() {
        ConfigurationManager configManager = getConfigManager();
        return new TodavClientBuilder()
                .withConfigManager(configManager)
                .build();
    }

    private ConfigurationManager getConfigManager() {
        return null;
    }
}
