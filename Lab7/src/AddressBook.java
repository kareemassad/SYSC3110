import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class AddressBook extends DefaultListModel {

    public AddressBook() {
        super();
    }

    public void addBuddy(BuddyInfo buddy_info_obj) {
        super.addElement(buddy_info_obj);
    }

    public void removeBuddy(BuddyInfo buddy_info_obj) {
        super.removeElement(buddy_info_obj);
    }

    public DefaultListModel<String> getString() {
        DefaultListModel<String> temp = new DefaultListModel<>();
        for (int i = 0; i < super.size(); i++) {
            temp.addElement(super.get(i).toString());
        }
        return temp;
    }

    // create a method that reads your exported file and recreates the addressBook.
    public static AddressBook importAddressBook(String fileName) {
        AddressBook addressBook = new AddressBook();
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String allInfo = input.nextLine();
                BuddyInfo buddy = BuddyInfo.importBuddyInfo(allInfo);
                addressBook.addBuddy(buddy);
            }
        } catch (IOException ae) {
            ae.printStackTrace();
        }
        return addressBook;
    }

    public static void main(String[] args) {
        String fileName = "test.txt";
        AddressBook addressbook = importAddressBook(fileName);
        // AddressBook addressBook = new AddressBook();
        // BuddyInfo base = new BuddyInfo();
        // addressBook.addBuddy(base);
        // System.out.println(addressBook.getString());
    }

}

// public static void main(String[] args) {
// BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
// AddressBook addressBook = new AddressBook();
// addressBook.addBuddy(buddy);
// addressBook.removeBuddy(buddy);
// BuddyInfo marge = new BuddyInfo();
// BuddyInfo homer = new BuddyInfo("Homer", "742 Evergreen Terrace,
// Springfield", "555-1111" );
// BuddyInfo bart = new BuddyInfo("Bart", "742 Evergreen Terrace, Springfield",
// "555-2222" );
// BuddyInfo lisa = new BuddyInfo("Lisa", "742 Evergreen Terrace, Springfield",
// "555-3333" );
// BuddyInfo maggie = new BuddyInfo("Maggie", "742 Evergreen Terrace,
// Springfield", "555-4444" );

// NEW BRANCH
// addBuddy(marge);
// addBuddy(homer);
// System.out.println(list);
// removeBuddy(homer);
// System.out.println(list);
// list.add(homer);
// list.add(bart);
// list.add(marge);
// list.add(lisa);
// list.add(maggie);
// System.out.println(list);
// System.out.println(marge.getName());
// }
// }
