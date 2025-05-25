package todav.core.configuration.model;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodavConfigurationTest {
    private TodavConfiguration configuration;

    @BeforeEach
    public void setup() {
        configuration = new TodavConfiguration();
    }

    @Test
    public void testFlattenMap() {
        Map<String, Object> globalConfig = Map.of(
                "configuration", Map.of(
                        "tasks", Map.of(
                                "defaults", Map.of(
                                        "tags", "inbox",
                                        "description", "this is a test"
                                )
                        )
                )
        );

        configuration.setGlobal(globalConfig);
        Map<String, Object> flat = configuration.flattenMap("", globalConfig, new HashMap<>());
        assertEquals(2, flat.size());

        String actualValue = flat.get("configuration.tasks.defaults.tags").toString();
        assertEquals("inbox", actualValue);
    }
}
