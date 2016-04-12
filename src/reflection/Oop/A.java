package reflection.Oop;

import java.util.Random;

/**
 * Created by Alexandr on 19.02.2016.
 */
public class A {
    protected static  int a;
    protected static  int b;

    public A() {
       a = new Random().nextInt();
       b =  new Random().nextInt();
    }
}
