package todav.core.caldav;

import todav.core.client.credentials.CaldavAccount;

public interface AccountSyncer {
    void sync(CaldavClient client);
    void scheduleSync(CaldavAccount account, int minutes);
}
