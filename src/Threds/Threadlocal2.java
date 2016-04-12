package Threds;

/**
 * Created by Alexandr on 20.03.2016.
 */
public class Threadlocal2 {
    public static void main(String[] args) throws InterruptedException {
        Threadlocal.local.set(23);
        System.out.println(Threadlocal.local.get());
        Thread.currentThread().sleep(1000 );
        Thread ss = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Threadlocal.local.get());
            }
        });
        ss.start();

    }
}
