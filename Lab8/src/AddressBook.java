import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AddressBook extends DefaultListModel implements Serializable {

    public AddressBook() {
        super();
    }

    public void addBuddy(BuddyInfo buddy_info_obj) {
        super.addElement(buddy_info_obj);
    }

    public void removeBuddy(BuddyInfo buddy_info_obj) {
        super.removeElement(buddy_info_obj);
    }

    public String printBuddyList() {
        String output = "";
        for (int i = 0; i < super.size(); i++) {
            BuddyInfo buddy_info_obj = (BuddyInfo) super.get(i);
            output += buddy_info_obj.toString() + "\n";
        }
        System.out.println(output);
        return output;
    }

    public int getBuddyCount() {
        return super.size();
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

    // public static AddressBook importSerializedAddressBook(String fileName) {

    // }

    public static void exportSerializedAddressBook(AddressBook addressBook) {

        try {
            FileOutputStream fileOut = new FileOutputStream("test.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(addressBook);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AddressBook importSerializedAddressBook(String serFile) {
        AddressBook book = null;
        try {
            FileInputStream fileIn = new FileInputStream(serFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            book = (AddressBook) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return book;

    }

    // create a method called toXML() that will export the addressBook to an XML
    // file.
    public static void toXML(AddressBook addressBook) {
        try {
            FileWriter fileWriter = new FileWriter("test.xml");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<addressBook>");
            bufferedWriter.newLine();
            /*
             * Format:
             * <buddy1>
             * <name>John Doe</name>
             * <number>12312415245</number>
             * <address>111 road</address>
             * </buddy1>
             * <buddy2>
             * <name>Lameo Doe</name>
             * <number>124238255</number>
             * <address>111 road</address>
             * </buddy2>
             */
            for (int i = 0; i < addressBook.size(); i++) {
                BuddyInfo buddy = (BuddyInfo) addressBook.get(i);
                bufferedWriter.write("\t");
                bufferedWriter.write("<buddy>");
                bufferedWriter.newLine();
                bufferedWriter.write("\t\t");
                bufferedWriter.write("<name>" + buddy.getName().replaceAll("\\s+", "") + "</name>");
                bufferedWriter.newLine();
                bufferedWriter.write("\t\t");
                bufferedWriter.write("<number>" + buddy.getNumber().replaceAll("\\s+", "") + "</number>");
                bufferedWriter.newLine();
                bufferedWriter.write("\t\t");
                bufferedWriter.write("<address>" + buddy.getAddress().replaceAll("\\s+", "") + "</address>");
                bufferedWriter.newLine();
                bufferedWriter.write("\t");
                bufferedWriter.write("</buddy>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</addressBook>");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AddressBook importAddressBookFromXML(String XMLFile) {
        // call XMLParseHandler to parse the XML file. Return the addressBook.
        AddressBook book = new AddressBook();
        try {
            XmlParseHandler.readSAX(new File(XMLFile));
            // SAXParserFactory factory = SAXParserFactory.newInstance();
            // SAXParser saxParser = factory.newSAXParser();
            // XmlParseHandler handler = new XmlParseHandler();
            // saxParser.parse(XMLFile, handler);
            // addressBook = handler.getAddressBook();
            book = XmlParseHandler.getAddressBook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

    }

    public static void main(String[] args) {
        String fileName = "test.txt";
        String serFile = "test.ser";
        // import addressbook from gui generated test.txt
        AddressBook addressbook = importAddressBook(fileName);
        System.out.println("Testing importAddressBook: " + addressbook);
        // export and serialize addressbook to test.ser
        exportSerializedAddressBook(addressbook);
        // read serialized file
        AddressBook book = importSerializedAddressBook(serFile);
        System.out.println("Testing importSerializedBook: " + book);


        // export to xml file from addressbook
        toXML(addressbook);
        // import from xml to addressbook
        book = importAddressBookFromXML("test.xml");
        System.out.println("Testing importSAddressBookFromXML: " + book);
    }
}