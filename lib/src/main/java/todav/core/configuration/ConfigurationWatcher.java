package todav.core.configuration;

import java.nio.file.Path;

public interface ConfigurationWatcher {
    void startWatching(Path configFile, Runnable onChange);
    void stopWatching();
}
