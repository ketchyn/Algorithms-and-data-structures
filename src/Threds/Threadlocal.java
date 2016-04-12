package Threds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alexandr on 20.03.2016.
 */
public class Threadlocal extends Thread {

     public  static final MyThreadlocal<Integer> local = new MyThreadlocal<>();

    public void run(){
        System.out.println(" first thread value  " + local.get());

        local.set(32);
        System.out.println(local.get());
    }

    public static void main(String[] args) throws InterruptedException {

        Thread a  = new Threadlocal();
        a.start();
        a.sleep(2000);

        Thread newThred = new Threadlocal();
        newThred.start();
        newThred.sleep(1000);
        Thread ww = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        });
        ww.start();
    }



     static class MyThreadlocal<T> {
        Map<Thread, T> map = new ConcurrentHashMap<>();

        public void set(T value){
            map.put(Thread.currentThread(), value);
        }
        public T get(){
            return map.get(Thread.currentThread());
        }
    }
}
