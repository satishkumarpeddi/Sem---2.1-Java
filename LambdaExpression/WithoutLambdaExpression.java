package LambdaExpression;
interface Greeting{
    void sayHello();
}
class Hello implements Greeting{
    public void sayHello(){
        System.out.println("Hello, Welcome!");
    }
}
public class WithoutLambdaExpression {
    public static void main(String[] args){
        Greeting g = new Hello();
        g.sayHello();
    }
}
