package ThreadEx;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Alexandr on 11.03.2016.
 */
public class MainApp {
    public static void main(String args[])
            throws Exception {
        int j = 0;
       /* for(int i = 0;i<10;i++) {
            Thread thread = new ClientSocket();
            thread.start();
           // i++;
        }*/
        Long starttime = new Date().getTime();
        ServerSocket ssock = new ServerSocket(8080,0, InetAddress.getByName("localhost"));
       // System.out.println("Listening");
        while (true) {
            Socket sock = ssock.accept();
          //  System.out.println("Connected");
            Long finaltime = new Date().getTime();
            new Thread(new MultiThreadServer(sock,j,starttime)).start();
            j++;

        }

    }
}
