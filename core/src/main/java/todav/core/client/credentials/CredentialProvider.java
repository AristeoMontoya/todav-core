package todav.core.client.credentials;

import java.util.Optional;

public interface CredentialProvider {
    Optional<Credentials> getCredentials(CaldavAccount account);
}
