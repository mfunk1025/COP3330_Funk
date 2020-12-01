import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    int answer;
    int regulator = 0;
    protected String fname;
    protected String lname;
    protected String phone;
    protected String email;

    public ContactItem createContactItem(String fname, String lname, String phone, String email) {

        ContactItem i = new ContactItem(fname,lname,phone,email);
        return i;
    }

    public void viewContactList(ArrayList<ContactItem> contact) {
        System.out.println("Current Contacts");
        System.out.println("----------------\n");

        for (int i = 0; i < contact.size(); i++) {
            System.out.print(i + ") Name: " + contact.get(i).getname() + "\n" +"Phone: " + contact.get(i).getPhone() + "\n" + "Email: " + contact.get(i).getEmail() + "\n");
        }
    }

    public String[] filebuild(ArrayList<ContactItem>  contact){

        String fileinput;
        String[] lines = new String[contact.size()];

        for (int i = 0; i < contact.size(); i++) {
            fileinput = (contact.get(i).getFname() + "\n"  + contact.get(i).getLname() + "\n" + contact.get(i).getPhone() + "\n" + contact.get(i).getEmail());
            if (i != contact.size() - 1){
                fileinput += "\n";
            }
            lines[i] = fileinput;
        }


        return lines;
    }

    public void save(String filename, ArrayList<ContactItem> contact) throws IOException {

        File file = new File(filename);
        String[] lines;
        lines = filebuild(contact);

        file.createNewFile();

        FileWriter writer = new FileWriter(file);
        for(int i = 0; i < contact.size(); i ++){
            writer.write(lines[i]);
        }
        writer.flush();
        writer.close();
    }

    public ArrayList<ContactItem> load(String filename) throws FileNotFoundException {

        ArrayList<ContactItem> contact = new ArrayList<ContactItem>();
        ContactList original = new ContactList();

        File file = new File(filename);
        Scanner reader1 = new Scanner(file);
        int counter = 1;

        while (reader1.hasNextLine()) {

            String fname = reader1.nextLine();
            String lname = reader1.nextLine();
            String phone = reader1.nextLine();
            String email = reader1.nextLine();

            ContactItem a = original.createContactItem(fname,lname,phone,email);
            contact.add(a);

        }

        return contact;
    }
}
