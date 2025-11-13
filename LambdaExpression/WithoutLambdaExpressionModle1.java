package LambdaExpression;
interface Greetings{
    void message();
}
public class WithoutLambdaExpressionModle1 {
    public static void main(String[] args){
        Greetings msg = () -> System.out.println("Hello, Welcome!");
        msg.message();
    }
}
