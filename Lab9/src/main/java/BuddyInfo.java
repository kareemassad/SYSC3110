import java.io.Serializable;

public class BuddyInfo implements Serializable {

    private String name;
    private String address;
    private String number;


    // Getter Methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String s) {
        name = s;
    }

    public void setAddress(String s) {
        address = s;
    }

    public void setNumber(String s) {
        number = s;
    }

    // Setter Method
    public void setInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    // Constructor
    public BuddyInfo() {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public String toString() {
        return (name + ", " + address + ", " + number);
    }

    // create a factory method to create a new BuddyInfo object
    public static BuddyInfo importBuddyInfo(String allInfo) {
        String[] info = allInfo.split(",");
        // So info[0] is the name, info[1] is the address, and info[2] is the number
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName(info[0]);
        buddy.setAddress(info[1]);
        buddy.setNumber(info[2]);
        return buddy;
    }

    // public static AddressBook importAddressBook(String fileName) {
    // AddressBook addressBook = new AddressBook();
    // try {
    // Scanner input = new Scanner(new File(fileName));
    // while (input.hasNextLine()) {
    // String allInfo = input.nextLine();
    // BuddyInfo buddy = BuddyInfo.importBuddyInfo(allInfo);
    // addressBook.addBuddy(buddy);
    // }
    // } catch (FileNotFoundException e) {
    // System.out.println("File not found");
    // }
    // return addressBook;
    // }

    // main
    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo();
        buddy.setInfo("Homer", "742 Evergreen Terrace, Springfield", "555-7334");
        String name = buddy.getName();
        System.out.println("Hello " + name);
    }

}
