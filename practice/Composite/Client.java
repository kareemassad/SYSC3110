package Composite;

public class Client {
    public static void main(String[] args) {
        // create a component tree
        Component component = new CompositeAccount();

        // all all customers to component
        component.add(new DepositAccount("DA001", 100));
        component.add(new DepositAccount("DA002", 2000));
        component.add(new SavingsAccount("123", 190));

        // get composite balance for the customer
        float totalBalance = component.getBalance();
        System.out.println("Total Balance: " + totalBalance);

        // AccountStatement mergedStatment = component.getStatement();
        // System.out.println("Merged Statement: " + mergedStatment);
    }

}
