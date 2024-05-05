package testcases.expandtesting.ui.endtoend;

import com.expandtesting.data.enums.NoteCategory;
import com.expandtesting.models.dto.Note;
import com.expandtesting.models.request.CreateNoteRequestFormParams;
import com.expandtesting.models.request.GetTokenRequestFormParams;
import com.expandtesting.pageobjects.LoginPage;
import com.expandtesting.pageobjects.WelcomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testcases.expandtesting.ui.BaseExpandTestingUiTest;

import java.util.Objects;

import static com.expandtesting.data.TestData.*;
import static core.data.RandomStringGenerator.generateRandomString;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("UI")
class EndToEndUiTest extends BaseExpandTestingUiTest {

    private ThreadLocal<Note> note;

    @BeforeEach
    void beforeEachTest() {
        note = ThreadLocal.withInitial(Note::new);
        note.set(Note.builder()
                .title(generateRandomString(40))
                .description(generateRandomString(256))
                .category(NoteCategory.PERSONAL)
                .isCompleted(false)
                .build());
    }

    @Tag("P1")
    @Test
    void checkEndToEndEndScenarioWithRemovingNoteOnlyUiApproach() {
        boolean noteExists = new WelcomePage().openPage()
                .openLoginPage()
                .loginWithEmailAndPassword(TEST_USER_EMAIL,TEST_USER_PASSWORD)
                .addNewNote()
                .createNote(note.get())
                .getNoteCardByCondition(noteCard -> Objects.equals(noteCard.getTitle(), note.get().getTitle()))
                .deleteNote()
                .clickDeleteButton()
                .doesNoteCartExist(noteCard -> Objects.equals(noteCard.getTitle(), note.get().getTitle()));

        assertThat(noteExists).isFalse();
    }

    @Tag("P1")
    @Test
    void checkEndToEndEndScenarioWithRemovingNoteOnlyHybridApproach() {
        String token = usersClient.get().getToken(GetTokenRequestFormParams.builder()
                .email(TEST_USER_EMAIL)
                .password(TEST_USER_PASSWORD)
                .build());

        notesClient.get().createNote(CreateNoteRequestFormParams.builder()
                .title(note.get().getTitle())
                .description(note.get().getDescription())
                .category(note.get().getCategory().getCategoryName())
                .build(), token);

        boolean noteExists = new LoginPage()
                .openPage()
                .loginWithToken(token)
                .getNoteCardByCondition(noteCard -> Objects.equals(noteCard.getTitle(), note.get().getTitle()))
                .deleteNote()
                .clickDeleteButton()
                .doesNoteCartExist(noteCard -> Objects.equals(noteCard.getTitle(), note.get().getTitle()));

        assertThat(noteExists).isFalse();
    }
}
