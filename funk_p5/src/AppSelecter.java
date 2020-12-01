import java.io.IOException;
import java.util.Scanner;

public class AppSelecter {

    public static void main(String[] Args) throws IOException {

        int answer = 0;
        Scanner input = new Scanner(System.in);

        while (answer != 3){
            displayMainmenu();
            answer = input.nextInt();

            if (answer == 1){
                TaskApp run = new TaskApp();
                run.entryPoint();
            }

            else if (answer == 2){
                ContactApp run = new ContactApp();
                run.entryPoint();
            }

            else if (answer == 3){
                return;
            }

            else{
                System.out.println("Sorry, your input does not match any of the selections.");
            }

        }
    }


    public static void displayMainmenu(){
        System.out.println("Select Your Application");
        System.out.println("-----------------------\n\n");
        System.out.println("1) Task List");
        System.out.println("2) Contact List");
        System.out.println("3) quit \n");
    }
}
