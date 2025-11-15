package domashka8_inkapsulation_OOPstudents.inkapsulation;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private String currency;
    private boolean isActive;
    private static int totalAccounts = 0;
    private final String BANK_NAME = "Национальный Банк";

    private static double calculateInterests(double amount, double rate, int years) {
        double skobka = (1 + rate / 100);
        double n = 1;
        for (int i = 0; i < years; i++) {
            n *= skobka;
        }
        return amount * skobka;
    }

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

    private String displayInfo(boolean showStatus) { // не совсем понмаю, зачем надо showstatus
        return accountNumber + '_' + currency + '_' + balance;
    }

    private void deposit(double d) {
        balance += d;
    }

    private void deposit(double d, String description) {
        System.out.println(description);
        balance += d;
    }

    private void withdraw(double w) {
        assert balance >= w;
        balance -= w;
    }

    private void withdraw(double w, String purpose) {
        assert balance >= w;
        balance -= w;
        System.out.println(purpose);
    }

    private void activateAccount() {
        isActive = true;
    }

    private  void deactivateAccount() {
        isActive = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        assert balance > 0 && balance <= 1000000;
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



}
