package testcases.expandtesting.api;

import com.expandtesting.client.NotesClient;
import com.expandtesting.client.UsersClient;
import com.expandtesting.models.request.GetTokenRequestFormParams;
import com.expandtesting.validator.NotesValidator;
import com.expandtesting.validator.UsersValidator;
import core.BaseApiTest;
import org.junit.jupiter.api.BeforeAll;

import static com.expandtesting.data.TestData.TEST_USER_EMAIL;
import static com.expandtesting.data.TestData.TEST_USER_PASSWORD;

public class BaseExpandTestingApiTest extends BaseApiTest {

    protected static ThreadLocal<UsersClient> usersClient;
    protected static ThreadLocal<NotesClient> notesClient;
    protected static ThreadLocal<UsersValidator> usersValidator;
    protected static ThreadLocal<NotesValidator> notesValidator;
    protected static ThreadLocal<String> token = ThreadLocal.withInitial(String::new);

    @BeforeAll
    static void setUp() {
        usersClient = ThreadLocal.withInitial(UsersClient::new);
        notesClient = ThreadLocal.withInitial(NotesClient::new);
        usersValidator = ThreadLocal.withInitial(() -> new UsersValidator(usersClient.get()));
        notesValidator = ThreadLocal.withInitial(() -> new NotesValidator(notesClient.get()));

        step("Get token");
        token.set(usersClient.get().getToken(GetTokenRequestFormParams.builder()
                .email(TEST_USER_EMAIL)
                .password(TEST_USER_PASSWORD)
                .build()));
    }
}

