package todav.core.configuration.model;

import java.util.Map;
import java.util.Optional;
import todav.core.configuration.Platform;
import todav.core.configuration.PlatformDetector;

public class TodavConfiguration {
    private Map<String, Object> global;
    private Map<String, Object> desktop;
    private Map<String, Object> android;

    public Object getConfigValue(String key) {
        Platform current = PlatformDetector.detectPlatform();
        Map<String, Object> platformConfig = current == Platform.ANDROID ? this.android : this.desktop;
        return Optional.ofNullable(platformConfig.get(key)).orElse(this.global.get(key));
    }

    public void setGlobal(Map<String, Object> global) {
        this.global = global;
    }

    public void setDesktop(Map<String, Object> desktop) {
        this.desktop = desktop;
    }

    public void setAndroid(Map<String, Object> android) {
        this.android = android;
    }
}
