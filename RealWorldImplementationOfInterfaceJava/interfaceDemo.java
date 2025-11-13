package RealWorldImplementationOfInterfaceJava;

interface Payment{
    void pay(double amount);
    void paymentType();
    default void paymentInfo(){
        System.out.println("All payments must be secure and verified.");
    }
}
class CreditCardPayment  implements Payment{
    public void pay(double amount){
        System.out.println("Paid $ "+amount+" using Credit Card.");
    }
    public void paymentType(){
        System.out.println("This is a Credit payment.");
    }
}
public class interfaceDemo {
    public static void main(String[] args){
        Payment p1 = new CreditCardPayment();
        p1.paymentType();
        p1.pay(200);
        p1.paymentInfo();
    }
}
