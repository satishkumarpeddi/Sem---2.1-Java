package LambdaExpression;
interface Operation{
    int calculate(int a,int b);
}
public class WithUsingLambdaExpression {
    public static void main(String[] args){
        Operation add = (a,b)->a+b;
        System.out.println("Sum : "+add.calculate(10,2));
    }
}
