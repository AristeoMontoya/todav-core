package todav.core.configuration.locator;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import todav.core.configuration.ConfigurationException;

public class DBConfigLocator implements ConfigurationLocator {
    private DataSource dataSource;

    public DBConfigLocator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Path getResolvedConfigPath() throws ConfigurationException {
        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new ConfigurationException("Unable to locate configuration from datasource", e);
        }
        return null;
    }
}
