import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ArrayList<ContactItem> a = new ArrayList<ContactItem>();
        ContactItem i = new ContactItem("Iwana", "Dye", "000-000-0000", "notreal@yapo.com");
        assertEquals(a.size(), 0);
        a.add(i);
        assertEquals(a.size(), 1);
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("", "Dye");
        assertEquals(a.getFname(), "");
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("Iwana", "");
        assertEquals(a.getLname(), "");
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setPhone("");
        assertEquals(a.getPhone(), "");
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem a = new ContactItem("Iwana", "Dye", "000-000-0000", "123@gmail.com");
        a.setName("Justin", "Kase");
        a.setPhone("010-000-0000");
        a.setEmail("124@yahoo.com");
        assertEquals(a.getFname(), "Justin");
        assertEquals(a.getLname(), "Kase");
        assertEquals(a.getEmail(), "124@yahoo.com");
        assertEquals(a.getPhone(), "010-000-0000");
    }

    @Test
    public void removingItemsDecreasesSize() {
        ArrayList<ContactItem> a = new ArrayList<ContactItem>();
        ContactItem i = new ContactItem("Iwana", "Dye", "000-000-0000", "notreal@yapo.com");
        a.add(i);
        assertEquals(a.size(), 1);
        a.remove(0);
        assertEquals(a.size(), 0);
    }
}