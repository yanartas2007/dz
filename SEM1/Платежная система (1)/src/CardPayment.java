public class CardPayment extends PaymentMethod implements Refundable{
    public CardPayment(double balance) {
        super(balance);
    }

    @Override
    public boolean returnCash(double cash) {
        if (cash <= 0) {return false;}
        setBalance(getBalance() + cash);
        return true;
    }

    @Override
    public boolean pay(double cash) {
        if (!canPay(cash / 100 * 102)) {return false;}
        setBalance(getBalance() - cash / 100 * 102);
        return true;
    }
}
