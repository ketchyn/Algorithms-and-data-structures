package All;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Alexandr on 05.02.2016.
 */
public class Ioexampe {


    public static void main(String[] args) throws IOException {
       /* String name = "texxxxxxxxxxxxxxxxxxxxxxxxxt.txt";//inputstrem/auotputsterm
        String sorce = "E:" + File.separator + name;
        File file = new File("E:/HelloWorld1.txt");
        System.out.println("Creating file "+ file.exists());

        File directory = new File("E://");

        OutputStream out = new FileOutputStream(file);

        System.out.println("Creating outpustream with file "  + file.exists());

        out.write(AA);
        System.out.println("write " + file.exists());
        out.close();

        System.out.println(file.getAbsolutePath());
        System.out.println(File.separator);
        String [] mass = directory.list();
        int j = 1;
        for (String i : mass) {
            System.out.println(j+ " "+ i );
            j++;
        }


*/
        char[] mass = {65000, 2565, 2566, 3061, 3064};
        byte[] b = {65, 66, 67, 68, 69};

        Writer writer = new FileWriter(new File("E:/Writer.txt"));
        writer.write(mass);

        writer.close();
        OutputStream out = new FileOutputStream("E:/Writer1.txt");
        out.write(b);

        Charset set = Charset.forName("UTF-8");


        Reader reader = new InputStreamReader(new FileInputStream("E:/Writer.txt"),set );
        int c=0;
        StringBuilder str = new StringBuilder();
        while(c!=-1){
            c =reader.read();
            str.append((char)c);
        }

        System.out.println(str.toString());
        System.out.println(Charset.defaultCharset().toString());




    }
}
