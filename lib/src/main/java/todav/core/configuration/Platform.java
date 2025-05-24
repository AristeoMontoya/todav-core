package todav.core.configuration;

import java.util.Optional;

public enum Platform {
    // Supported platforms at the moment.
    // Might add support for windows in the future.
    ANDROID("android"),
    LINUX("linux"),
    UNKNOWN("");

    public final String label;

    private Platform(String label) {
        this.label = label;
    }

    public static Optional<Platform> getPlatform(String label) {
        for (Platform platform : values()) {
            if (platform.label.equals(label)) {
                return Optional.of(platform);
            }
        }
        return Optional.empty();
    }
}
