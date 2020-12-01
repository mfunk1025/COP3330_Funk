public class TaskItem {
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
       if (title == ""){
           return;
       }

        Title = title;
    }

    public void setDescription(String description){
       if(description == ""){
           return;
       }

        Description = description;
    }

    public void setDueDate(String dueDate){
        if(dueDate == ""){
            return;
        }

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

