package todav.core.configuration.locator;

import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;
import todav.core.configuration.TodavConfigurationException;
import todav.core.configuration.Platform;
import todav.core.configuration.PlatformDetector;
import todav.core.persistence.StorageService;

public class BaseConfigurationLocator implements ConfigurationLocator {

    private final StorageService storageService;

    public BaseConfigurationLocator(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public Path getResolvedConfigPath() throws TodavConfigurationException {
        Optional<String> override = this.storageService.getConfigurationOverride("config_path");

        return override.map(Path::of)
                .orElseGet(this::getPlatformConfigurationPath);
    }

    private Path getPlatformConfigurationPath() {
        Platform currentPlatform = PlatformDetector.detectPlatform();

        // For now this is the only "implemented" platform.
        if (Objects.requireNonNull(currentPlatform) == Platform.LINUX) {
            return getLinuxPath();
        }
        throw new TodavConfigurationException("unable to locate configuration file");
    }

    private Path getLinuxPath() {
        String configPath = ".config/todav/todav.yaml";
        return Optional.ofNullable(System.getProperty("user.name"))
                .map(user -> Path.of(String.format("/home/%s/%s", user, configPath)))
                .orElseGet(() -> Path.of(String.format("~/%s", configPath)));
    }
}