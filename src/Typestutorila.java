/**
 * Created by Alexandr on 15.03.2016.
 */
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Byte.*;

 class Typestutorila {

   private  class b{


    }
    public static void main(String[] args) throws IOException {

        TreeMap<Integer, Integer> tree = new TreeMap<>();
        tree.put(1, 1);
        tree.put(2, 2);
        tree.put(3, 3);
        tree.put(4, 4);

        Set a = tree.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterr = a.iterator();
        while (iterr.hasNext()) {

            System.out.println(iterr.next().getKey());;

        }
     /*   Double AA = 1.23434454;
        System.out.println(AA.byteValue());
        byte k = 0;





     //byte b = (byte) AA;
        DataOutputStream out = new DataOutputStream(new FileOutputStream("input.txt"));
        ObjectOutputStream c = new ObjectOutputStream(new FileOutputStream("input.txt"));
        c.writeObject(AA);*/
       // Scanner scn = new Scanner(new File("input.txt")).use;
       // String  AA = "\b.*\\*\b";

     //   while (scn.hasNext()) {
     //       System.out.println(scn.next());
        }



    }

     /*   for(int i = 0 ; i < 4 ; ) {
            switch(new Integer(i++)) {
                case 1:
                    System.out.print("one ");
                    break;
                case 3:
                    System.out.print("three ");
                case 4:
                    System.out.print("four ");
                case 5:
                    System.out.print("four ");
                case 6:
                    System.out.print("four ");
                default:
                    System.out.print("def ");
            }
        }
    }*/


