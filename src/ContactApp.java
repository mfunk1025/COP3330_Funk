import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {
    public void entryPoint() throws IOException {
        runContactList();
    }

    public void runContactList() throws IOException {

        String holdfname;
        String holdlname;
        String holdphone;
        String holdemail;
        int quit = 0;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int answerq1, answerq2 = 0;

        while (quit == 0){
            displayMainmenu();
            answerq1 = input.nextInt();

            if (answerq1 == 1){

                ArrayList<ContactItem> contact = new ArrayList<ContactItem>();
                ContactList original = new ContactList();

                while (answerq2 != 6){
                    displayListOperation();
                    answerq2 = input.nextInt();

                    if (answerq2 == 1){
                        original.viewContactList(contact);
                    }

                    else if (answerq2 == 2){
                        System.out.print("First Name: ");
                        holdfname = input2.nextLine();

                        while (holdfname.length() < 1) {
                            System.out.println("WARNING: First name must contain 1 or more character");
                            System.out.print("First Name: ");
                            holdfname = input2.nextLine();
                        }

                        System.out.print("Last Name: ");
                        holdlname = input2.nextLine();

                        while (holdlname.length() < 1){
                            System.out.println("WARNING: Last name must contain 1 or more character");
                            System.out.print("Last Name: ");
                            holdlname = input2.nextLine();
                        }

                        System.out.print("Phone Number (XXX-XXX-XXXX): ");
                        holdphone = input2.nextLine();

                        while (holdphone.length() != 12 || holdphone.charAt(3) != '-' || holdphone.charAt(7) != '-'){
                            System.out.println("WARNING: Phone number must be in (XXX-XXX-XXXX) format");
                            System.out.print("Phone Number (XXX-XXX-XXXX): ");
                            holdphone = input2.nextLine();
                        }

                        System.out.print("Email: ");
                        holdemail = input2.nextLine();

                        while(holdemail.contains("@") != true){
                            System.out.println("Warning: The email you have entered does not contain valid mailbox");
                            System.out.print("Email: ");
                            holdemail = input2.nextLine();
                        }

                        ContactItem i = original.createContactItem(holdfname,holdlname,holdphone,holdemail);
                        contact.add(i);

                    }

                    else if (answerq2 == 3){
                        original.viewContactList(contact);

                        if (contact.size() < 1) {
                            System.out.println("WARNING: there are no contacts to edit");
                        }

                        else {
                            System.out.print("Which contact will you edit? ");
                            int a = input.nextInt();


                            System.out.print("Enter a new first name for contact " + a + ": ");
                            holdfname = input3.nextLine();

                            while (holdfname.length() < 1) {
                                System.out.println("WARNING: First name must contain 1 or more charcters");
                                System.out.print("Enter a new first name for contact " + a + ": ");
                                holdfname = input3.nextLine();
                            }

                            System.out.print("Enter a new last name for contact " + a + ": ");
                            holdlname = input3.nextLine();

                            while (holdlname.length() < 1) {
                                System.out.println("WARNING: Last name must contain 1 or more charcters");
                                System.out.print("Enter a new last name for contact " + a + ": ");
                                holdlname = input3.nextLine();
                            }

                            contact.get(a).setName(holdfname,holdlname);

                            System.out.print("Enter a phone number for contact " + a + " (XXX-XXX-XXXX): ");
                            holdphone = input3.nextLine();
                            while (holdphone.length() != 12 || holdphone.charAt(3) != '-' || holdphone.charAt(7) != '-'){
                                System.out.println("WARNING: Phone number must be in (XXX-XXX-XXXX) format");
                                System.out.print("Enter a phone number for contact " + a + " (XXX-XXX-XXXX): ");
                                holdphone = input3.nextLine();
                            }
                            contact.get(a).setPhone(holdphone);

                            System.out.print("Enter a email for contact " + a + ": ");
                            holdemail = input3.nextLine();

                            while(holdemail.contains("@") != true){
                                System.out.println("Warning: The email you have entered does not contain valid mailbox");
                                System.out.print("Enter a email for contact " + a + ": ");
                                holdemail = input3.nextLine();
                            }

                            contact.get(a).setEmail(holdemail);
                    }

                }
                    else if(answerq2 == 4){

                        original.viewContactList(contact);

                        if (contact.size() < 1) {
                            System.out.println("WARNING: there are no contacts to remove");

                        }

                        else {
                            System.out.print("Which contact will you remove? ");
                            int a = input.nextInt();
                            contact.remove(a);
                        }
                    }

                    else if (answerq2 == 5){
                        System.out.print("Enter a filename to save as: ");
                        String Filename = input.next();

                        original.save(Filename,contact);
                    }

                    else if(answerq2 > 6 || answerq2 < 1){
                        System.out.println("Sorry, the input you provided doesn't match any of the operations.");
                    }
                }
            }

            else if(answerq1 == 2){
                ArrayList<ContactItem> contact = new ArrayList<ContactItem>();
                ContactList original = new ContactList();

                System.out.print("Enter the filename to load: ");
                String holder = input.next();

                contact = original.load(holder);

                answerq2 = 0;

                while (answerq2 != 6){
                    displayListOperation();
                    answerq2 = input.nextInt();

                    if (answerq2 == 1){
                        original.viewContactList(contact);
                    }

                    else if (answerq2 == 2){
                        System.out.print("First Name: ");
                        holdfname = input2.nextLine();

                        while (holdfname.length() < 1) {
                            System.out.println("WARNING: First name must contain 1 or more character");
                            System.out.print("First Name: ");
                            holdfname = input2.nextLine();
                        }

                        System.out.print("Last Name: ");
                        holdlname = input2.nextLine();

                        while (holdlname.length() < 1){
                            System.out.println("WARNING: Last name must contain 1 or more character");
                            System.out.print("Last Name: ");
                            holdlname = input2.nextLine();
                        }

                        System.out.print("Phone Number (XXX-XXX-XXXX): ");
                        holdphone = input2.nextLine();

                        while (holdphone.length() != 12 || holdphone.charAt(3) != '-' || holdphone.charAt(7) != '-'){
                            System.out.println("WARNING: Phone number must be in (XXX-XXX-XXXX) format");
                            System.out.print("Phone Number (XXX-XXX-XXXX): ");
                            holdphone = input2.nextLine();
                        }

                        System.out.print("Email: ");
                        holdemail = input2.nextLine();

                        while(holdemail.contains("@") != true){
                            System.out.println("Warning: The email you have entered does not contain valid mailbox");
                            System.out.print("Email: ");
                            holdemail = input2.nextLine();
                        }

                        ContactItem i = original.createContactItem(holdfname,holdlname,holdphone,holdemail);
                        contact.add(i);

                    }

                    else if (answerq2 == 3){
                        original.viewContactList(contact);

                        if (contact.size() < 1) {
                            System.out.println("WARNING: there are no contacts to edit");
                        }

                        else {
                            System.out.print("Which contact will you edit? ");
                            int a = input.nextInt();


                            System.out.print("Enter a new first name for contact " + a + ": ");
                            holdfname = input3.nextLine();

                            while (holdfname.length() < 1) {
                                System.out.println("WARNING: First name must contain 1 or more charcters");
                                System.out.print("Enter a new first name for contact " + a + ": ");
                                holdfname = input3.nextLine();
                            }

                            System.out.print("Enter a new last name for contact " + a + ": ");
                            holdlname = input3.nextLine();

                            while (holdlname.length() < 1) {
                                System.out.println("WARNING: Last name must contain 1 or more charcters");
                                System.out.print("Enter a new last name for contact " + a + ": ");
                                holdlname = input3.nextLine();
                            }

                            contact.get(a).setName(holdfname,holdlname);

                            System.out.print("Enter a phone number for contact " + a + " (XXX-XXX-XXXX): ");
                            holdphone = input3.nextLine();
                            while (holdphone.length() != 12 || holdphone.charAt(3) != '-' || holdphone.charAt(7) != '-'){
                                System.out.println("WARNING: Phone number must be in (XXX-XXX-XXXX) format");
                                System.out.print("Enter a phone number for contact " + a + " (XXX-XXX-XXXX): ");
                                holdphone = input3.nextLine();
                            }
                            contact.get(a).setPhone(holdphone);

                            System.out.print("Enter a email for contact " + a + ": ");
                            holdemail = input3.nextLine();

                            while(holdemail.contains("@") != true){
                                System.out.println("Warning: The email you have entered does not contain valid mailbox");
                                System.out.print("Enter a email for contact " + a + ": ");
                                holdemail = input3.nextLine();
                            }

                            contact.get(a).setEmail(holdemail);
                        }

                    }
                    else if(answerq2 == 4){

                        original.viewContactList(contact);

                        if (contact.size() < 1) {
                            System.out.println("WARNING: there are no contacts to remove");

                        }

                        else {
                            System.out.print("Which contact will you remove? ");
                            int a = input.nextInt();
                            contact.remove(a);
                        }
                    }

                    else if (answerq2 == 5){
                        System.out.print("Enter a filename to save as: ");
                        String Filename = input.next();

                        original.save(Filename,contact);
                    }

                    else if(answerq2 > 6 || answerq2 < 1){
                        System.out.println("Sorry, the input you provided doesn't match any of the operations.");
                    }
                }
            }

            else {
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
    }


}
