package All;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alexandr on 28.12.2015.
 */
public class ArraysMerge {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[] res = new Integer [n];


        for(int i = 0; i<res.length; i++){
                res[i]=scn.nextInt();
            }
        Arrays.sort(res);
        for(Integer i:res){
            System.out.print(i+ " ");
        }

        }
}

