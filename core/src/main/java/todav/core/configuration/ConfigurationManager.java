package todav.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.yaml.snakeyaml.Yaml;

public class ConfigurationManager {
    private Path configLocation;
    private ConfigurationWatcher watcher;
    private Yaml yaml;

    private Map<String, Object> config;

    public ConfigurationManager(Path configLocation, ConfigurationWatcher watcher) {
        this.configLocation = configLocation;
        this.watcher = watcher;
        this.yaml = new Yaml();
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

    public void createDefaultConfigFile() {

    }

    public boolean getAsBoolean(String configuration, boolean defaultValue) {
       return Optional.ofNullable(this.config.get(configuration))
               .map(val -> Boolean.getBoolean((String) val))
               .orElse(defaultValue);
    }
}
