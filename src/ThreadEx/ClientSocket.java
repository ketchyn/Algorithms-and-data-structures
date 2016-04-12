package ThreadEx;

import java.io.*;
import java.net.Socket;

/**
 * Created by Alexandr on 11.03.2016.
 */
public class ClientSocket extends Thread {


    @Override
    public void run() {
        Socket s = null;
        try {
            s = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter out = null;
       //OutputStream out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int i = 0;

            while(i<=5000){
                this.sleep(1);
                out.write("Hello");
                //out.write("Heelo".getBytes());
                i++;

            }
            System.out.println("_________________________________________________");

           out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
