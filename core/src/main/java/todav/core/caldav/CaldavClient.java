package todav.core.caldav;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import todav.core.client.credentials.Credentials;

public class CaldavClient {
    private URI server;
    private Credentials credentials;

    public CaldavClient(URI server, Credentials credentials) {
        this.server = server;
        this.credentials = credentials;
    }

    public List<Object> getRemoteEvents(ZonedDateTime from, ZonedDateTime to) {
        return null;
    }

    public void putEvent(Object event) {

    }

    public void deleteEvent(Object event) {

    }
}
