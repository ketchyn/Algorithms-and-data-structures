package All;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Alexandr on 21.01.2016.
 */
public class HashTableStepic {
    public static void main(String[] args) throws IOException {
        HashSet<String> table = new HashSet<>();
        String digit;
        String next;
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            digit = scn.next();
            if(digit == "q") System.in.close();
            switch(digit){
                case "+" :
                    next = scn.next();
                    if(table.contains(next)) {
                    System.out.println("FAIL");
                    }
                    else {
                    table.add(next);
                    System.out.println("OK");
                    }
                    break;

                case "-":
                    next= scn.next();
                    if(table.contains(next)){
                        table.remove(next);
                        System.out.println("OK");
                    }else System.out.println("FAIL");
                    break;
                case "?":
                    next= scn.next();
                    if(table.contains(next)){
                        System.out.println("OK");
                    }else System.out.println("FAIL");
                    break;


            }

        }


    }


}
