package ThreadEx;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MultiThreadServer implements Runnable {
    Socket csocket;
    int i;
    Long startTime;
    MultiThreadServer(Socket csocket, int i, Long starttime) {
        this.csocket = csocket;
        this.i = i;
        this.startTime = starttime;
    }


    public void run() {
        try {
            InputStream inputStream = csocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
           // System.out.println(this.i);
            PrintStream out = null;
            out = new PrintStream
                    (csocket.getOutputStream());
            while (in.read()!=-1) {

                line = in.readLine();
                if(line.equals("Bue")) {
                    out.close();
                    csocket.close();
                } else
                {

                    out.print(line);
                }
                //  System.out.println(line);

            }
            //Long currrentTime = new Date().getTime();
           // System.out.println(currrentTime-startTime);
            if (out!=null) {
                out.close();
            }
            if (csocket!=null) {
                csocket.close();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}