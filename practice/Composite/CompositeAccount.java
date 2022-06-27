package Composite;

public class CompositeAccount extends Component {
    private float totalBalance;
    private AccountStatement compositeStmt, individualStmt;

    public float getBalance() {
        totalBalance = 0;
        for (Component c : list) {
            totalBalance += c.getBalance();
        }
        return totalBalance;
    }

    public AccountStatement getStatement() {
        for (Component c : list) {
            individualStmt = c.getStatement();
            compositeStmt.merge(individualStmt);
        }
        return compositeStmt;
    }

}
