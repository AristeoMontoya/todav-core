package todav.core.configuration.locator;

import java.nio.file.Path;

public interface ConfigurationLocator {
    Path getResolvedConfigPath();
}
