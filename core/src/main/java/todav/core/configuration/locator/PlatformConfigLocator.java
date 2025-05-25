package todav.core.configuration.locator;

import java.nio.file.Path;
import java.util.Optional;
import todav.core.configuration.Platform;
import todav.core.configuration.PlatformDetector;

public class PlatformConfigLocator implements ConfigurationLocator {

    @Override
    public Path getResolvedConfigPath() {
        Platform currentPlatform = PlatformDetector.detectPlatform();
        Path path = null;
        // For now this is the only "implemented" platform.
        switch (currentPlatform) {
            case LINUX -> path =  getLinuxPath();
        }
        return path;
    }

    private Path getLinuxPath() {
        String configPath = ".config/todav/todav.yaml";
        return Optional.ofNullable(System.getProperty("user.name"))
                .map(user -> Path.of(String.format("/home/%s/%s", user, configPath)))
                .orElseGet(() -> Path.of(String.format("~/%s", configPath)));
    }
}
