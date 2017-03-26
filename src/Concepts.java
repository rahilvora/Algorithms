/**
 * Created by rahilvora on 3/25/17.
 */
public class Concepts extends Class1 {
    public static void main(String args[]){
        Class1 concepts = new Concepts();
        concepts.someMethod();
        concepts.someMethod2();
    }

    public void someMethod(){
        System.out.println("Some method");
    }
    public void method(){
        System.out.println(" method ");
    }
}

abstract class Class1 extends Class2{
    public void someMethod2(){
        System.out.println("Here");
    }
}

abstract class Class2 implements Skeleton{

    public abstract void someMethod();
}

interface Skeleton{
    public abstract void method();
}