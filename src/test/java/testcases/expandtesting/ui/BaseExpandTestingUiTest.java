package testcases.expandtesting.ui;

import com.expandtesting.client.NotesClient;
import com.expandtesting.client.UsersClient;
import org.junit.jupiter.api.BeforeAll;

public class BaseExpandTestingUiTest {
    protected static ThreadLocal<UsersClient> usersClient;
    protected static ThreadLocal<NotesClient> notesClient;

    @BeforeAll
    static void setUp() {
        usersClient = ThreadLocal.withInitial(UsersClient::new);
        notesClient = ThreadLocal.withInitial(NotesClient::new);
    }
}
