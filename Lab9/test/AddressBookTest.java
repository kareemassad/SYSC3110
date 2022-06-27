import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AddressBookTest {
    private AddressBook addressBook;
    private BuddyInfo buddy1;

    // public AddressBookTest(AddressBook address, BuddyInfo buddy1) {
    // this.address = address;
    // this.buddy1 = buddy1;
    // }
    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
        buddy1 = new BuddyInfo();
        buddy1.setAddress("ss");
        buddy1.setName("s");
        buddy1.setNumber("sss");
        addressBook.addBuddy(buddy1);
    }

    @Test
    public void testAddBuddy() {
        addressBook.addBuddy(buddy1);
        assertEquals(2, addressBook.getBuddyCount());
    }

    @Test
    public void testRemoveBuddy() {
        addressBook.addBuddy(buddy1);
        addressBook.removeBuddy(buddy1);
        assertEquals(1, addressBook.getBuddyCount());
    }

    @Test
    public void testPrintBuddyList() {
        addressBook.addBuddy(buddy1);
        addressBook.printBuddyList();
    }

    @Test
    public void testImportAddressBook() {
        String fileName = "test.txt";
        AddressBook book = AddressBook.importAddressBook(fileName);
        System.out.println(book);
        assertEquals("[name1,  addy1,  num1   , name2,  addy2,  num2   ]", book.toString());
    }

    @Test
    public void testExportSerializedAddressBook() {

        AddressBook.exportSerializedAddressBook(addressBook);
    }

    @Test
    public void testImportSerializedAddressBook() {
        // read ser file
        String serFile = "test.ser";
        AddressBook book = AddressBook.importSerializedAddressBook(serFile);
        System.out.println(book);
        assertEquals("[s, ss, sss]", book.toString());
    }

    @Test
    public void testToXML() {
        AddressBook.toXML(addressBook);
    }

    @Test
    public void testImportAddressBookFromXML() {
        String xmlFile = "test.xml";
        AddressBook book = AddressBook.importAddressBookFromXML(xmlFile);
        System.out.println(book);
        assertEquals("[s, ss, sss]", book.toString());
    }
}
