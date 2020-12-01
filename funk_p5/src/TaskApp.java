import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp {

    public void entryPoint() throws IOException {
        runTaskList();
    }

    public void runTaskList() throws IOException {

        String holdTitle;
        String holdDescription;
        String holdDueDate;
        int quit = 0;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int answerq1, answerq2;

        while(quit == 0) {

            displayMainmenu();
            answerq1 = input.nextInt();

            if (answerq1 == 1) {

                ArrayList<TaskItem> task = new ArrayList<TaskItem>();
                TaskList original = new TaskList();
                answerq2 = 0;

                while (answerq2 != 8) {
                    displayListOperation();
                    answerq2 = input.nextInt();

                    if (answerq2 == 1) {
                        original.viewTaskList(task);

                    } else if (answerq2 == 2) {

                        System.out.print("Task Title: ");
                        holdTitle = input2.nextLine();

                        while (holdTitle.length() < 1) {
                            System.out.println("WARNING: Title must contain 1 or more words");
                            System.out.print("Task Title: ");
                            holdTitle = input2.nextLine();
                        }

                        System.out.print("Task Description: ");
                        holdDescription = input2.nextLine();

                        while (holdDescription.length() < 1) {
                            System.out.println("WARNING: Description must contain 1 or more words");
                            System.out.print("Task Descrption: ");
                            holdDescription = input2.nextLine();
                        }


                        System.out.print("Task Due Date (YYYY-MM-DD): ");
                        holdDueDate = input2.nextLine();

                        while (holdDueDate.length() != 10 || holdDueDate.charAt(4) != '-' || holdDueDate.charAt(7) != '-') {
                            System.out.println("WARNING: Task Due Date must be in (YYYY-MM-DD) format");
                            System.out.print("Task Due Date (YYYY-MM-DD): ");
                            holdDueDate = input2.nextLine();
                        }


                        TaskItem i = original.createTaskItem(holdTitle, holdDescription, holdDueDate);
                        task.add(i);

                    } else if (answerq2 == 3) {

                        original.viewTaskList(task);

                        if (task.size() < 1) {
                            System.out.println("WARNING: there are no tasks to edit");
                        }

                        else {
                            System.out.print("Which task will you edit? ");
                            int a = input.nextInt();


                            System.out.print("Enter a new title for task " + a + ": ");
                            holdTitle = input3.nextLine();

                            while (holdTitle.length() < 1) {
                                System.out.println("WARNING: Title must contain 1 or more words");
                                System.out.print("Enter a new title for task " + a + ": ");
                                holdTitle = input2.nextLine();
                            }
                            task.get(a).setTitle(holdTitle);

                            System.out.print("Enter a new description for task " + a + ": ");
                            holdDescription = input3.nextLine();
                            while (holdDescription.length() < 1) {
                                System.out.println("WARNING: Description must contain 1 or more words");
                                System.out.print("Enter a new description for task " + a + ": ");
                                holdDescription = input2.nextLine();
                            }
                            task.get(a).setDescription(holdDescription);

                            System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + a + ": ");
                            holdDueDate = input3.nextLine();
                            while (holdDueDate.length() != 10 || holdDueDate.charAt(4) != '-' || holdDueDate.charAt(7) != '-') {
                                System.out.println("WARNING: Task Due Date must be in (YYYY-MM-DD) format");
                                System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + a + ": ");
                                holdDueDate = input2.nextLine();
                            }
                            task.get(a).setDueDate(holdDueDate);
                        }
                    }
                    else if (answerq2 == 4) {
                        original.viewTaskList(task);

                        if (task.size() < 1) {
                            System.out.println("WARNING: there are no tasks to remove");

                        }

                        else {
                            System.out.print("Which task will you remove? ");
                            int a = input.nextInt();
                            task.remove(a);
                        }
                    }

                    else if (answerq2 == 5) {
                        int completetask = 0;

                        if (task.size() == 0) {
                            System.out.println("WARNING: there are 0 tasks");

                        }

                        else {
                            for (int a = 0; a < task.size(); a++) {
                                if (task.get(a).getComplete() == 1) {
                                    completetask += 1;
                                }
                            }

                            if (completetask == task.size()) {
                                System.out.print("WARNING: all tasks are completed");
                            }

                            else {
                                original.Uncompletetasks(task);
                                System.out.print("Which task will you mark as complete? ");
                                int a = input.nextInt();
                                task.get(a).setComplete();
                            }
                        }

                    }
                    else if (answerq2 == 6) {
                        int uncompletetask = 0;

                        if (task.size() == 0) {
                            System.out.println("WARNING: there are 0 tasks");

                        }

                        else {
                            for (int a = 0; a < task.size(); a++) {
                                if (task.get(a).getComplete() == 0)
                                    uncompletetask += 1;
                            }


                            if (uncompletetask == task.size()) {
                                System.out.println("WARNING: all tasks are uncompleted");

                            }

                            else {original.CompleteTasks(task);
                                System.out.print("Which task will you mark as uncomplete? ");
                                int a = input.nextInt();
                                task.get(a).setUncomplete();}
                        }
                    }

                    else if (answerq2 == 7) {
                        System.out.print("Enter a filename to save as: ");
                        String Filename = input.next();

                        original.save(Filename, task);
                    }

                    else if(answerq2 > 8 || answerq2 < 1){
                        System.out.println("Sorry, the input you provided doesn't match any of the operations.");
                    }

                }

            }

            else if(answerq1 == 2){

                ArrayList<TaskItem> task = new ArrayList<TaskItem>();
                TaskList original = new TaskList();

                System.out.print("Enter the filename to load: ");
                String holder = input.next();

                task = original.load(holder);

                answerq2 = 0;

                while (answerq2 != 8) {
                    displayListOperation();
                    answerq2 = input.nextInt();

                    if (answerq2 == 1) {
                        original.viewTaskList(task);

                    } else if (answerq2 == 2) {

                        System.out.print("Task Title: ");
                        holdTitle = input2.nextLine();

                        while (holdTitle.length() < 1) {
                            System.out.println("WARNING: Title must contain 1 or more words");
                            System.out.print("Task Title: ");
                            holdTitle = input2.nextLine();
                        }

                        System.out.print("Task Description: ");
                        holdDescription = input2.nextLine();

                        while (holdDescription.length() < 1) {
                            System.out.println("WARNING: Description must contain 1 or more words");
                            System.out.print("Task Descrption: ");
                            holdDescription = input2.nextLine();
                        }


                        System.out.print("Task Due Date (YYYY-MM-DD): ");
                        holdDueDate = input2.nextLine();

                        while (holdDueDate.length() != 10 || holdDueDate.charAt(4) != '-' || holdDueDate.charAt(7) != '-') {
                            System.out.println("WARNING: Task Due Date must be in (YYYY-MM-DD) format");
                            System.out.print("Task Due Date (YYYY-MM-DD): ");
                            holdDueDate = input2.nextLine();
                        }


                        TaskItem i = original.createTaskItem(holdTitle, holdDescription, holdDueDate);
                        task.add(i);

                    } else if (answerq2 == 3) {

                        original.viewTaskList(task);

                        if (task.size() < 1) {
                            System.out.println("WARNING: there are no tasks to edit");
                        }

                        else {
                            System.out.print("Which task will you edit? ");
                            int a = input.nextInt();


                            System.out.print("Enter a new title for task " + a + ": ");
                            holdTitle = input3.nextLine();

                            while (holdTitle.length() < 1) {
                                System.out.println("WARNING: Title must contain 1 or more words");
                                System.out.print("Enter a new title for task " + a + ": ");
                                holdTitle = input2.nextLine();
                            }
                            task.get(a).setTitle(holdTitle);

                            System.out.print("Enter a new description for task " + a + ": ");
                            holdDescription = input3.nextLine();
                            while (holdDescription.length() < 1) {
                                System.out.println("WARNING: Description must contain 1 or more words");
                                System.out.print("Enter a new description for task " + a + ": ");
                                holdDescription = input2.nextLine();
                            }
                            task.get(a).setDescription(holdDescription);

                            System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + a + ": ");
                            holdDueDate = input3.nextLine();
                            while (holdDueDate.length() != 10 || holdDueDate.charAt(4) != '-' || holdDueDate.charAt(7) != '-') {
                                System.out.println("WARNING: Task Due Date must be in (YYYY-MM-DD) format");
                                System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + a + ": ");
                                holdDueDate = input2.nextLine();
                            }
                            task.get(a).setDueDate(holdDueDate);
                        }
                    }
                    else if (answerq2 == 4) {
                        original.viewTaskList(task);

                        if (task.size() < 1) {
                            System.out.println("WARNING: there are no tasks to remove");

                        }

                        else {
                            System.out.print("Which task will you remove? ");
                            int a = input.nextInt();
                            task.remove(a);
                        }
                    }

                    else if (answerq2 == 5) {
                        int completetask = 0;

                        if (task.size() == 0) {
                            System.out.println("WARNING: there are 0 tasks");

                        }

                        else {
                            for (int a = 0; a < task.size(); a++) {
                                if (task.get(a).getComplete() == 1) {
                                    completetask += 1;
                                }
                            }

                            if (completetask == task.size()) {
                                System.out.print("WARNING: all tasks are completed");
                            }

                            else {
                                original.Uncompletetasks(task);
                                System.out.print("Which task will you mark as complete? ");
                                int a = input.nextInt();
                                task.get(a).setComplete();
                            }
                        }

                    }
                    else if (answerq2 == 6) {
                        int uncompletetask = 0;

                        if (task.size() == 0) {
                            System.out.println("WARNING: there are 0 tasks");

                        }

                        else {
                            for (int a = 0; a < task.size(); a++) {
                                if (task.get(a).getComplete() == 0)
                                    uncompletetask += 1;
                            }


                            if (uncompletetask == task.size()) {
                                System.out.println("WARNING: all tasks are uncompleted");

                            }

                            else {original.CompleteTasks(task);
                                System.out.print("Which task will you mark as uncomplete? ");
                                int a = input.nextInt();
                                task.get(a).setUncomplete();}
                        }
                    }

                    else if (answerq2 == 7) {
                        System.out.print("Enter a filename to save as: ");
                        String Filename = input.next();

                        original.save(Filename, task);
                    }

                }



            }

            else if(answerq1 == 3){

                quit = 1;
            }


        }

        return;
    }

    public static void displayMainmenu(){
        System.out.println("Main Menu");
        System.out.println("---------\n\n");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit \n");
    }

    public static void displayListOperation(){
        System.out.println("List Operation Menu");
        System.out.println("-------------------\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
    }



}
