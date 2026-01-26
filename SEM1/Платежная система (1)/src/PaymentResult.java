public class PaymentResult {
    private boolean isNormal;
    private double paySum;
    private double newBalance;

    public PaymentResult(boolean isNormal, double paySum, double newBalance) {
        setNormal(isNormal);
        setPaySum(paySum);
        setNewBalance(newBalance);
    }


    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public double getPaySum() {
        return paySum;
    }

    public void setPaySum(double paySum) {
        this.paySum = paySum;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }
}
