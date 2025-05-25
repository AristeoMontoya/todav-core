package todav.core.configuration;

/**
 * OS Detector Service
 */
public class PlatformDetector {

    public static Platform detectPlatform() {
        String osName = System.getProperty("os.name").toLowerCase();
        return Platform.getPlatform(osName);
    }
}
