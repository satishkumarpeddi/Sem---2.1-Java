package AbstractionUsingJava;
interface PaymentGateway{
    void payAmount(double amount);
}
class CreditCardPayment implements PaymentGateway{
    public void payAmount(double amount){
        System.out.println("The amount transation (Credit Transation) : "+amount);
    }
}
class UpiPayment implements PaymentGateway{
    public void payAmount(double amount){
        System.out.println("The amount transation (Upi Transation) : "+amount);
    }
}
class NetBankPayment implements PaymentGateway{
    public void payAmount(double amount){
        System.out.println("The amount transation (NetBanking Transation) : "+amount);
    }
}
public class demoAbstraction {
    public static void main(String[] args){
        PaymentGateway p1 = new CreditCardPayment();
        PaymentGateway p2 = new UpiPayment();
        PaymentGateway p3 = new NetBankPayment();
        p1.payAmount(200);
        p2.payAmount(100);
        p3.payAmount(400);

    }
}
