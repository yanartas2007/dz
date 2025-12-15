public abstract class PaymentMethod {
    private double balance;

    public PaymentMethod(double startBalance) {
        setBalance(startBalance);
    }

    public boolean canPay(double sum) {
        return getBalance() >= sum;
    }

    public abstract boolean pay(double sum);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
        this.balance = balance;
        }
    }
}
