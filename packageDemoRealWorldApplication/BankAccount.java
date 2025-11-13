package packageDemoRealWorldApplication;

public class BankAccount {
    private String name;
    private double balance;
    public BankAccount(String name,double balance){
        this.name=name;
        this.balance=balance;
    }
    public void displayMethod(){
        System.out.println("The bank holder name : "+name);
        System.out.println("The balance amount the account :"+this.balance);
    }
}
