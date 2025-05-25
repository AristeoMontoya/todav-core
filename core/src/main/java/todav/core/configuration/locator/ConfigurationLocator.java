package todav.core.configuration.locator;

import java.nio.file.Path;
import todav.core.configuration.TodavConfigurationException;

public interface ConfigurationLocator {
    Path getResolvedConfigPath() throws TodavConfigurationException;
}