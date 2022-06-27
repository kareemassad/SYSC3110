import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class labGui extends JFrame implements ActionListener {
    private AddressBook book;
    private JList addressList;
    private JMenuBar menubar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem createItem = new JMenuItem("Create");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JMenuItem loadItem = new JMenuItem("Show");
    private JMenuItem addItem = new JMenuItem("Add");
    private JMenuItem removeItem = new JMenuItem("Remove");
    private JMenuItem editItem = new JMenuItem("Edit");
    private JPanel panel = new JPanel(new BorderLayout());

    public labGui(String text){
        super(text);

        createItem.addActionListener(this);
        fileMenu.add(createItem);

        saveItem.addActionListener(this);
        fileMenu.add(saveItem);
        saveItem.setEnabled(false);

        loadItem.addActionListener(this);
        fileMenu.add(loadItem);
        loadItem.setEnabled(false);

        addItem.addActionListener(this);
        fileMenu.add(addItem);
        addItem.setEnabled(false);

        removeItem.addActionListener(this);
        fileMenu.add(removeItem);
        removeItem.setEnabled(false);

        editItem.addActionListener(this);
        fileMenu.add(editItem);
        editItem.setEnabled(false);

        menubar.add(fileMenu);
        setJMenuBar(menubar);
        add(panel);
        panel.setVisible(true);
    }
    public static void main(String[] args){
        labGui frame1 = new labGui("Lab5 Gui");
        frame1.setSize(500,500);
        frame1.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String buttonClicked = e.getActionCommand();

        if(buttonClicked == "Create"){

            book = new AddressBook();
            addressList = new JList(book);
            addressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            panel.add(addressList, BorderLayout.CENTER);
            addressList.setVisible(true);

            createItem.setEnabled(false);
            saveItem.setEnabled(true);
            loadItem.setEnabled(true);
            addItem.setEnabled(true);
            removeItem.setEnabled(true);
            editItem.setEnabled(true);

        }
        else if(buttonClicked == "Save"){
            String x = "";

            DefaultListModel temp = book.getString();
            for(int i=0; i<temp.size(); ++i){
                x+=(temp.get(i) +"   \n");
            }

            String filename = JOptionPane.showInputDialog("Enter Filename with file extension:  (ex. test.txt)");

            try{BufferedWriter out = new BufferedWriter(new FileWriter(filename));
                out.write(x);

                out.close();
            }
            catch(IOException ae){
                ae.printStackTrace();
            }

        }
        else if(buttonClicked == "Show"){
            addressList.setModel(book);

        }
        else if(buttonClicked == "Add"){
            String name= JOptionPane.showInputDialog("Enter Name:");
            String address= JOptionPane.showInputDialog("Enter Address:");
            String number= JOptionPane.showInputDialog("Enter Number:");
            BuddyInfo temp = new BuddyInfo();
            temp.setInfo(name,address, number);
            book.addBuddy(temp);
        }

        else if(buttonClicked == "Remove"){
            book.removeBuddy((BuddyInfo)addressList.getSelectedValue());
        }

        else if(buttonClicked == "Edit"){
            String name= JOptionPane.showInputDialog("Enter Name:");
            String address= JOptionPane.showInputDialog("Enter Address:");
            String number= JOptionPane.showInputDialog("Enter Number:");
            BuddyInfo temp = new BuddyInfo();
            temp.setInfo(name,address,number);
            book.removeBuddy((BuddyInfo)addressList.getSelectedValue());
            book.addBuddy(temp);
        }

    }
}