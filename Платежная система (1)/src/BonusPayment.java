public class BonusPayment extends PaymentMethod{
    public BonusPayment(double cash) {
        super(cash);
    }

    @Override
    public boolean pay(double cash) {
        if (!canPay(cash)) {return false;}
        setBalance(getBalance() - cash);
        return true;
    }
}
