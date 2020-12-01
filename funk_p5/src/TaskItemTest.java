import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskItemTest {

    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        assertEquals(a.getDueDate(), "2020-12-01");
    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        assertEquals(a.getTitle(), "Testing");
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.setDescription("Testing02");
        assertEquals(a.getDescription(), "Testing02");
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.setDueDate("2020-12-02");
        assertEquals(a.getDueDate(), "2020-12-02");
    }

    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.setTitle("");
        assertEquals(a.getTitle(), "Testing");
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.setTitle("Testing02");
        assertEquals(a.getTitle(), "Testing02");
    }

}