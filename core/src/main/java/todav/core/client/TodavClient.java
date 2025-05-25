package todav.core.client;

import java.util.List;
import todav.core.client.credentials.CaldavAccount;
import todav.core.client.credentials.CredentialProvider;
import todav.core.configuration.ConfigurationManager;
import todav.core.event.EventManager;
import todav.core.sync.SyncService;

public class TodavClient {
    private ConfigurationManager configurationManager;
    private EventManager eventManager;
    private SyncService syncService;
    private CredentialProvider credentialProvider;

    List<CaldavAccount> accounts;

    public TodavClient(
            ConfigurationManager configManager,
            EventManager eventManager,
            SyncService syncService,
            CredentialProvider credentialProvider
    ) {
        this.configurationManager = configManager;
        this.eventManager = eventManager;
        this.syncService = syncService;
        this.credentialProvider = credentialProvider;
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
