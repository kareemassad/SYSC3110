package Composite;

public class SavingsAccount extends Component {
    private String accountNumber;
    private float accountBalance;

    private AccountStatement currentStmt;

    public SavingsAccount(String accountNumber, float accountBalance) {
        super();
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return accountBalance;
    }

    public AccountStatement getStatement() {
        return currentStmt;
    }

}
