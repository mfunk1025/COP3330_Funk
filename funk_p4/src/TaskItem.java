public class TaskItem extends TaskList{

    protected int TaskItemComplete = 0;
    protected int TaskListComplete = 0;

    protected String Title;
    protected String Description;
    protected String DueDate;
    private int complete = 0;

    public TaskItem(String title, String description, String dueDate){

        Title = title;
        Description = description;
        DueDate = dueDate;

    }

    public String getTitle(){
        return Title;
    }

    public String getDescription(){
        return Description;
    }

    public String getDueDate(){
        return DueDate;
    }

    public void setTitle(String title){
        Title = title;
    }

    public void setDescription(String description){
        Description = description;
    }

    public void setDueDate(String dueDate){

        DueDate = dueDate;
    }

    public void setComplete(){
        complete = 1;
    }

    public int getComplete(){
        return complete;
    }

    public void setUncomplete(){
        complete = 0;
    }
}
