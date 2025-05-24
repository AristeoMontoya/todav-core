package todav.core.client;

import todav.core.configuration.ConfigurationManager;
import todav.core.event.EventManager;

public class TodavClient {

    private ConfigurationManager configurationManager;
    private EventManager eventManager;

    public TodavClient(
            ConfigurationManager configManager,
            EventManager eventManager
    ) {
        this.configurationManager = configManager;
        this.eventManager = eventManager;
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
