package domashka7_OOP;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private String currency;
    private boolean isActive;

    private BankAccount(String accountNumber, String ownerName, double balance, String currency, boolean isActive) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.currency = currency;
        this.isActive = isActive;
    }

    private BankAccount(String accountNumber, String ownerName) {
        this(accountNumber, ownerName, 0.0, "валютакакаято", false);
    }

    private BankAccount() {
        this("-1", "Имя");
    }

    private String displayInfo() {
        return accountNumber + '_' + currency + '_' + balance;
    }

    private void deposit(double d) {
        balance += d;
    }

    private void withdraw(double w) {
        assert balance >= w;
        balance -= w;
    }

    private void activateAccount() {
        isActive = true;
    }

    private  void deactivateAccount() {
        isActive = false;
    }

}
