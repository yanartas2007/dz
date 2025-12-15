public class PaymentService {
    public static PaymentResult pay(PaymentMethod pm, double sum) {
        if (pm.pay(sum)) {
            return new PaymentResult(true, sum, pm.getBalance());
        }
        return new PaymentResult(false, sum, pm.getBalance());
    }

    public static PaymentResult returnCash(PaymentMethod pm, double sum) {
        if (pm instanceof Refundable) {
            if (((Refundable) pm).returnCash(sum)) {
                return new PaymentResult(true, -sum, pm.getBalance());
            }
        }
        return new PaymentResult(false, -sum, pm.getBalance());
    }
}

