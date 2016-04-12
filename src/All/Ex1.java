package All;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alexandr on 16.12.2015.
 */
public class Ex1 {


    static String returnNutural(int num){
        List<Integer> res = new ArrayList<Integer>();

        int natuaralNum = 2;
        while(natuaralNum <= num){
            if(num % natuaralNum == 0){
                num = num / natuaralNum;
                res.add(natuaralNum);
            }else{
                natuaralNum++;
            }
        }

        return res.toString().replace("[", "").replace("]", "").replaceAll(",", "");
    }
    public static void main( String[] args )   {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



    }
}





















