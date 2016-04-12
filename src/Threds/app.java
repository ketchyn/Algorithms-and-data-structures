package Threds;

import sun.plugin2.main.server.HeartbeatThread;

/**
 * Created by Alexandr on 04.03.2016.
 */
public class app {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread( new HelloThread());
        Long start = System.nanoTime();
        thread.start();
        Long end = System.nanoTime();
        Long div = end-start;
        System.out.println("div = "+ div);

        start = System.nanoTime();

        Thread thread2 = new Helloworld2();
        thread2.start();
        end = System.nanoTime();
        System.out.println("div2= " + div);
        System.out.println("app-thread");

    }
}
