import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    private final ToDo testCase = new ToDo("eat potato");

    @Test
    void testToString() {
        assertEquals(testCase.toString(), "[T][✘] eat potato");
    }
}

