package reflection.Oop;

import java.util.Random;

/**
 * Created by Alexandr on 19.02.2016.
 */
public class Genarator {

    public  static Integer generate() {
        Random random = new Random();
        return new Integer(random.nextInt());
    }
}
