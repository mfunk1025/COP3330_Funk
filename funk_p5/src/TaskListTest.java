import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        assertEquals(a.size(), 0);
        a.add(b);
        assertEquals(a.size(), 1);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getComplete(),0);
        a.get(0).setComplete();
        assertEquals(a.get(0).getComplete(),1);
    }



    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getDescription(), "Testing");
        a.get(0).setDescription("New Testing");
        assertEquals(a.get(0).getDescription(), "New Testing");
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getDueDate(), "2020-12-01");
        a.get(0).setDueDate("2020-12-02");
        assertEquals(a.get(0).getDueDate(), "2020-12-02");
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getTitle(), "Testing");
        a.get(0).setTitle("");
        assertEquals(a.get(0).getTitle(), "Testing");
    }


    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getTitle(),"Testing");
        a.get(0).setTitle("New Testing");
        assertEquals(a.get(0).getTitle(), "New Testing");
    }


    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getDescription(),"Testing01");
    }


    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getDueDate(),"2020-12-01");
    }


    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getTitle(),"Testing");
    }


    @Test
    public void removingItemsDecreasesSize(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.add(b);
        assertEquals(a.get(0).getTitle(),"Testing");
    }


    @Test
    public void uncompletingTaskItemChangesStatus(){
        ArrayList<TaskItem> a = new ArrayList<TaskItem>();
        TaskItem b = new TaskItem("Testing", "Testing01", "2020-12-01");
        a.add(b);
        a.get(0).setComplete();
        assertEquals(a.get(0).getComplete(), 1);
        a.get(0).setUncomplete();
        assertEquals(a.get(0).getComplete(), 0);
    }


}