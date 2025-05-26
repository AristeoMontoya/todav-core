package todav.core.configuration.model;

public enum TodavConfigurationValues {
    SYNC_INTERVAL("sync.interval");

    public String key;

    private TodavConfigurationValues(String key) {
        this.key = key;
    }
}
