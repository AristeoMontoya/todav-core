package todav.core.configuration;

import java.nio.file.Path;

public class ConfigurationManager {
    private Path configLocation;
    private ConfigurationWatcher watcher;

    public ConfigurationManager(Path configLocation, ConfigurationWatcher watcher) {
        this.configLocation = configLocation;
        this.watcher = watcher;
    }
}
