package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testcases.expandtesting.api.BaseExpandTestingApiTest;

public class BaseApiTest {

    private static final ThreadLocal<Logger> logger = ThreadLocal.withInitial(() -> LoggerFactory.getLogger(BaseExpandTestingApiTest.class));

    public static void step(String message) {
        logger.get().info(message);
    }
}
