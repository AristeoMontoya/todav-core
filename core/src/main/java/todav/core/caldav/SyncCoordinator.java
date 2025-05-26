package todav.core.caldav;

import java.util.ArrayList;
import java.util.List;
import todav.core.client.credentials.CaldavAccount;
import todav.core.client.credentials.CredentialProvider;

public class SyncCoordinator {
    AccountSyncer syncer;
    CredentialProvider credentialProvider;
    List<CaldavClient> clients;

    public SyncCoordinator(List<CaldavAccount> accounts, AccountSyncer syncer, CredentialProvider credentialProvider) {
        this.syncer = syncer;
        this.credentialProvider = credentialProvider;
        initializeSyncers(accounts);
        syncNow();
    }

    private void initializeSyncers(List<CaldavAccount> accounts) {
        List<CaldavClient> initializedClients = new ArrayList<>();
        for (CaldavAccount account : accounts) {
            credentialProvider.getCredentials(account).ifPresent(credentials -> {
                CaldavClient accountClient = new CaldavClient(account.getServer(), credentials);
                initializedClients.add(accountClient);
            });
        }

        this.clients = initializedClients;
    }

    public void syncNow() {
        this.clients.forEach(syncer::sync);
    }
}
