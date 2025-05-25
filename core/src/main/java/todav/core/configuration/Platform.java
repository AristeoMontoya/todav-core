package todav.core.configuration;

import java.util.Optional;

public enum Platform {
    // Supported platforms at the moment.
    // Might add support for windows in the future.
    ANDROID("android"),
    LINUX("linux"),
    UNKNOWN("unknown");

    public final String label;

    private Platform(String label) {
        this.label = label;
    }

    public static Platform getPlatform(String label) {
        for (Platform platform : values()) {
            if (platform.label.equals(label)) {
                return platform;
            }
        }
        return UNKNOWN;
    }
}
