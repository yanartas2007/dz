public class CorporatePayment extends PaymentMethod implements Refundable{
    public double limit;

    public CorporatePayment(double cash, double limit) {
        super(cash);
        setLimit(limit);
    }

    public void setLimit(double limit) {
    }

    public double getLimit() {return limit;}

    @Override
    public boolean returnCash(double cash) {
        if (cash <= 0) {return false;}
        setBalance(getBalance() + cash);
        return true;
    }

    @Override
    public boolean pay(double cash) {
        if (cash > limit) {return false;}
        if (canPay(cash)) {
                if (!canPay(cash / 100 * 102)) {return false;}
                setBalance(getBalance() - cash / 100 * 102);
                return true;
            }
        return false;
    }
}
