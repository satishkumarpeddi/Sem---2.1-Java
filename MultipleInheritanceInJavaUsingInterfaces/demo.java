package MultipleInheritanceInJavaUsingInterfaces;
interface A{
     default void diplay(){
        System.out.println("Display Method of A interface .");
     }
}
interface B{
    default void display(){
        System.out.println("Display Method of B interface . ");
    }
}
class C implements A,B{
    public void display(){
        A.super.diplay();
        System.out.println("Display Method of C class");   
    }
}
public class demo {
    public static void main(String[] args){
        C obj = new C();
        obj.display();
    }
}
