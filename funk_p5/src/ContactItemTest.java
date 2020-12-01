import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactItemTest {

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "");
        assertEquals(a.getEmail(), "");
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem a = new ContactItem("", "Dye", "000-000-0000", "123@gmail.com");
        assertEquals(a.getFname(), "");
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
            ContactItem a = new ContactItem("Iwana", "", "000-000-0000", "123@gmail.com");
            assertEquals(a.getLname(), "");
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem a = new ContactItem("Iwana", "Dye", "", "123@gmail.com");
        assertEquals(a.getPhone(), "");
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        assertEquals(a.getPhone(), "000-000-0000");
        assertEquals(a.getLname(), "Dye");
        assertEquals(a.getFname(), "Iwana");
        assertEquals(a.getEmail(), "123@gmail.com");
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setEmail("");
        assertEquals(a.getEmail(), "");

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("", "Dye");
        assertEquals(a.getFname(), "");
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("Iwana", "");
        assertEquals(a.getLname(), "");
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setPhone("");
        assertEquals(a.getPhone(), "");
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("Justin", "Kase");
        a.setPhone("010-000-0000");
        a.setEmail("124@yahoo.com");
        assertEquals(a.getFname(), "Justin");
        assertEquals(a.getLname(), "Kase");
        assertEquals(a.getEmail(),"124@yahoo.com");
        assertEquals(a.getPhone(), "010-000-0000");
    }

}