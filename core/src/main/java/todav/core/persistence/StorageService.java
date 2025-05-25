package todav.core.persistence;

import java.util.Optional;

public interface StorageService {
    /**
     * Returns a configuration override defined in a data storage.
     * @return Optional configuration override.
     */
    Optional<String> getConfigurationOverride(String configKey);
}
