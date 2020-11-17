
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class TaskList extends App {


    int answer;
    int regulator = 0;
    protected String Title;
    protected String Description;
    protected String Date;



    public TaskItem createTaskItem(String title, String description, String date) {

        TaskItem i = new TaskItem(title, description, date);
        return i;
    }

    public void viewTaskList(ArrayList<TaskItem> task) {
        System.out.println("Current Tasks");
        System.out.println("-------------\n");

        for (int i = 0; i < task.size(); i++) {

            if (task.get(i).getComplete() == 1) {
                System.out.print("*** ");
            }

            System.out.println(i + ") [" + task.get(i).getDueDate() + "] " + task.get(i).getTitle() + ": " + task.get(i).getDescription());
        }
    }

    public void Uncompletetasks(ArrayList<TaskItem> task) {
        System.out.println("Uncompleted tasks");
        System.out.println("-----------------\n");

        for (int i = 0; i < task.size(); i++) {

            if (task.get(i).getComplete() == 0) {
                System.out.println(i + ") [" + task.get(i).getDueDate() + "] " + task.get(i).getTitle() + ": " + task.get(i).getDescription());
            }
        }
    }

    public void CompleteTasks(ArrayList<TaskItem> task) {
        System.out.println("Completed tasks");
        System.out.println("-----------------\n");

        for (int i = 0; i < task.size(); i++) {

            if (task.get(i).getComplete() == 1) {
                System.out.println(i + ") [" + task.get(i).getDueDate() + "] " + task.get(i).getTitle() + ": " + task.get(i).getDescription());
            }
        }
    }

    public String[] filebuild(ArrayList<TaskItem> task){

        String fileinput;
        String[] lines = new String[task.size()];

        for (int i = 0; i < task.size(); i++) {
                fileinput = (task.get(i).getDueDate() + "\n"  + task.get(i).getTitle() + "\n" + task.get(i).getDescription());
                if (i != task.size() - 1){
                    fileinput += "\n";
                }
                lines[i] = fileinput;
        }

            return lines;
    }


    public void save(String filename, ArrayList<TaskItem> task) throws IOException {

        File file = new File(filename);
        String[] lines;
        lines = filebuild(task);

        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < task.size(); i ++){
         writer.write(lines[i]);
        }
        writer.flush();
        writer.close();

    }

    public ArrayList<TaskItem> load(String filename) throws FileNotFoundException {

        ArrayList<TaskItem> task = new ArrayList<TaskItem>();
        TaskList original = new TaskList();

        File file = new File(filename);
        Scanner reader1 = new Scanner(file);
        int counter = 1;

        while (reader1.hasNextLine()) {

            String DueDate = reader1.nextLine();
            String Title = reader1.nextLine();
            String Description = reader1.nextLine();

            TaskItem a = original.createTaskItem(Title, Description, DueDate);
            task.add(a);

        }

        return task;
    }
}
