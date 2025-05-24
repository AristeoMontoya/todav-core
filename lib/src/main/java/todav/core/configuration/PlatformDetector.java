package todav.core.configuration;

/**
 * OS Detector Service
 */
public class PlatformDetector {

    public static Platform detectorPlatform() {
        String osName = System.getProperty("os.name").toLowerCase();
        /* TODO: It really doesn't make sense to use optional here if
         *  I'll be returning null anyway. Need to revisit this.
         *  Yay, first piece of tech debt.
         */
        return Platform.getPlatform(osName).orElse(null);
    }
}
