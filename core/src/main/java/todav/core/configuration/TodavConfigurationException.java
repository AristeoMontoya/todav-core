package todav.core.configuration;

public class TodavConfigurationException extends RuntimeException {
    public TodavConfigurationException(String message) {
        super(message);
    }

    public TodavConfigurationException(String message, Throwable e) {
        super(message, e);
    }
}
