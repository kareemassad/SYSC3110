import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XmlParseHandler extends DefaultHandler {
    private static final String TAG_ADDRESSBOOK = "addressbook";
    private static final String TAG_BUDDY = "buddy";
    private static final String TAG_NAME = "name";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_NUMBER = "number";

    private static AddressBook addressbook;
    private StringBuilder textElement;

    public static void readSAX(File f) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser s = spf.newSAXParser();

        DefaultHandler dh = new DefaultHandler() {
            Boolean checkerName = false;
            Boolean checkerNumber = false;
            Boolean checkerAddress = false;

            BuddyInfo buddy = new BuddyInfo();

            public void startDocument() throws SAXException {
                // System.out.println("Start document");
                addressbook = new AddressBook();
            }

            public void startElement(String u, String In, String qName, Attributes a) {
                // System.out.println("START: " + qName);
                // create buddyInfo objects and add to addressbook.
                if (qName.equals(TAG_BUDDY)) {
                    buddy = new BuddyInfo();
                }
                if (qName.equals(TAG_NAME)) {
                    checkerName = true;
                }
                if (qName.equals(TAG_NUMBER)) {
                    checkerNumber = true;
                }
                if (qName.equals(TAG_ADDRESS)) {
                    checkerAddress = true;
                }
            }

            public void endElement(String uri, String localName, String qName) {
                // System.out.println("END: " + qName);
                if (qName.equals(TAG_BUDDY)) {
                    addressbook.addBuddy(buddy);
                }
            }

            public void characters(char[] ch, int start, int length) {
                // System.out.println("CHARS: " + new String(ch, start, length));
                if (checkerName) {
                    buddy.setName(new String(ch, start, length));
                    checkerName = false;
                }
                if (checkerNumber) {
                    buddy.setNumber(new String(ch, start, length));
                    checkerNumber = false;
                }
                if (checkerAddress) {
                    buddy.setAddress(new String(ch, start, length));
                    checkerAddress = false;
                }

            }
        };
        s.parse(f, dh);
    }

    public static void main(String[] args) {
        try {
            readSAX(new File("test.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(addressbook);
    }

    public static AddressBook getAddressBook() {
        return addressbook;
    }

}
