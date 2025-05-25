package todav.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Optional;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import todav.core.configuration.model.TodavConfiguration;

public class ConfigurationManager {
    private Path configLocation;
    private ConfigurationWatcher watcher;
    private Yaml yaml;

    private TodavConfiguration config;

    public ConfigurationManager(Path configLocation, ConfigurationWatcher watcher) {
        this.configLocation = configLocation;
        this.watcher = watcher;
        this.yaml = new Yaml(new Constructor(TodavConfiguration.class, new LoaderOptions()));
        try {
            loadConfigFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadConfigFile() throws FileNotFoundException {
        if (this.configLocation.toFile().exists()) {
            InputStream fileStream = new FileInputStream(this.configLocation.toFile());
            this.config = yaml.load(fileStream);
        }
    }

    public boolean getAsBoolean(String configuration, boolean defaultValue) {
       return Optional.ofNullable(this.config.getConfigValue(configuration))
               .map(val -> Boolean.getBoolean((String) val))
               .orElse(defaultValue);
    }
}
