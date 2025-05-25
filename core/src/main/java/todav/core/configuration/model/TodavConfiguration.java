package todav.core.configuration.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import todav.core.client.credentials.CaldavAccount;
import todav.core.configuration.Platform;

public class TodavConfiguration {
    private List<CaldavAccount> accounts;

    private Map<String, Object> global;
    private Map<String, Object> desktop;
    private Map<String, Object> android;

    public void setGlobal(Map<String, Object> global) {
        this.global = global;
    }

    public void setDesktop(Map<String, Object> desktop) {
        this.desktop = desktop;
    }

    public void setAndroid(Map<String, Object> android) {
        this.android = android;
    }

    public List<CaldavAccount> getAccounts() {
        return this.getAccounts();
    }

    public Map<String, Object> getFlatConfigurationMap(Platform platform) {
        Map<String, Object> platformConfig = platform == Platform.ANDROID ?
                this.android :
                this.desktop;

        Map<String, Object> flatMap = flattenMap("", this.global, new HashMap<>());
        if (platformConfig != null) {
            flatMap.putAll(platformConfig);
        }

        return flatMap;
    }

    private Map<String, Object> flattenMap(String prefix, Map<String, Object> source, Map<String, Object> flattened) {
        for (Map.Entry entry : source.entrySet()) {
            String currentPrefix = prefix.isEmpty() ?
                    entry.getKey().toString() :
                    String.format("%s.%s", prefix, entry.getKey());
            Object value = entry.getValue();
            if (value instanceof Map<?, ?>) {
                return flattenMap(currentPrefix, (Map<String, Object>) value, flattened);
            } else {
                flattened.put(currentPrefix, entry.getValue());
            }
        }
        return flattened;
    }
}