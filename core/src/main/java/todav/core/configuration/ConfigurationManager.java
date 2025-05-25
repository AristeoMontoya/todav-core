package todav.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import todav.core.configuration.model.TodavConfiguration;

public class ConfigurationManager {
    private Yaml yaml;
    private TodavConfiguration todavConfiguration;
    private Map<String, Object> configMap;

    private Platform platform;

    public ConfigurationManager(Path configLocation) {
        this.platform = PlatformDetector.detectPlatform();
        this.yaml = new Yaml(new Constructor(TodavConfiguration.class, new LoaderOptions()));
        try {
            loadConfigFile(configLocation);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadConfigFile(Path configLocation) throws FileNotFoundException {
        if (configLocation.toFile().exists()) {
            InputStream fileStream = new FileInputStream(configLocation.toFile());
            this.todavConfiguration = yaml.load(fileStream);
            this.configMap = todavConfiguration.getFlatConfigurationMap(this.platform);
        }
    }

    public boolean getAsBoolean(String configuration, boolean defaultValue) {
       return Optional.ofNullable(this.configMap.get(configuration))
               .map(val -> Boolean.getBoolean((String) val))
               .orElse(defaultValue);
    }
}
