package todav.core.client;

import java.util.List;
import todav.core.client.credentials.CaldavAccount;
import todav.core.client.credentials.CredentialProvider;
import todav.core.client.credentials.Credentials;
import todav.core.configuration.ConfigurationManager;
import todav.core.caldav.event.EventManager;
import todav.core.caldav.AccountSyncer;

public class TodavClient {
    private ConfigurationManager configurationManager;
    private EventManager eventManager;
    private AccountSyncer accountSyncer;
    private CredentialProvider credentialProvider;

    List<CaldavAccount> accounts;

    public TodavClient(
            ConfigurationManager configManager,
            EventManager eventManager,
            AccountSyncer accountSyncer,
            CredentialProvider credentialProvider
    ) {
        this.configurationManager = configManager;
        this.eventManager = eventManager;
        this.accountSyncer = accountSyncer;
        this.credentialProvider = credentialProvider;
        // Initialize accounts
        List<CaldavAccount> accounts = configManager.getAccounts();

        // Initial sync
        for(CaldavAccount account : accounts) {
            Credentials credentials = credentialProvider.getCredentials(account).orElse(null);
            accountSyncer.sync(account);
        }

        // Schedule sync
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
