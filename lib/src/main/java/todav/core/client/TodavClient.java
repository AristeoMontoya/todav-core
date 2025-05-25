package todav.core.client;

import todav.core.configuration.ConfigurationManager;
import todav.core.event.EventManager;
import todav.core.sync.SyncService;

public class TodavClient {
    private ConfigurationManager configurationManager;
    private EventManager eventManager;
    private SyncService syncService;

    public TodavClient(
            ConfigurationManager configManager,
            EventManager eventManager,
            SyncService syncService
    ) {
        this.configurationManager = configManager;
        this.eventManager = eventManager;
        this.syncService = syncService;
    }

    public String getConfigurationString() {
        return null;
    }

    public int getConfigurationInt() {
        return 0;
    }

    public boolean getConfigurationBoolean() {
        return false;
    }
}
