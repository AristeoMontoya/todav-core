package todav.core.client.credentials;

import java.net.URI;

public class CaldavAccount {
    private String name;
    private URI server;
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getServer() {
        return server;
    }

    public void setServer(URI server) {
        this.server = server;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
