package todav.core.client;

import todav.core.configuration.ConfigurationManager;
import todav.core.configuration.Platform;
import todav.core.configuration.PlatformDetector;
import todav.core.event.EventManager;
import todav.core.sync.SyncService;

public class TodavClientBuilder {
    private ConfigurationManager configManager;
    private EventManager eventManager;
    private SyncService syncService;

    public TodavClientBuilder withConfigManager(ConfigurationManager configManager) {
        this.configManager = configManager;
        return this;
    }

    public TodavClientBuilder withEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
        return this;
    }

    public TodavClientBuilder withSyncService(SyncService syncService) {
        this.syncService = syncService;
        return this;
    }

    public TodavClientBuilder withDetectedPlatformDefaults() {
        Platform platform = PlatformDetector.detectPlatform();
        return this;
    }

    public TodavClient build() {
        return new TodavClient(
                this.configManager,
                this.eventManager,
                this.syncService
        );
    }
}
