package Threds;

/**
 * Created by Alexandr on 10.03.2016.
 */
public class Automic extends Thread {
    volatile static int i;
    boolean b;

    public void run() {
        while (true) {
            if (b = !b) i++;
            else i--;
        }
    }

    public static void main(String[] args) {
        new Automic().start();
        new Automic().start();

        while (true)
            System.out.println(i);
    }
}
