public class BuddyInfo {

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

    // Setter Method
    public void setInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public BuddyInfo() {
        this("Marge", "742 Evergreen Terrace, Springfield", "555-1234");
    }

    // Constructor
    public BuddyInfo(String name, String address, String number) {
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
        return new BuddyInfo(info[0], info[1], info[2]);
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
        BuddyInfo base = new BuddyInfo();
        String test = base.name;
        System.out.println(test);

        BuddyInfo obj = new BuddyInfo("Homer", "742 Evergreen Terrace, Springfield", "555-7334");
        String name = obj.getName();
        System.out.println("Hello " + name);
    }
}
