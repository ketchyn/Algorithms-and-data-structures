package All;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alexandr on 13.01.2016.
 */
public class Quicksort2 {
    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k =scn.nextInt();
        int[] a = new int[n];
        for(int i = 0; i< a.length; i++){
            a[i] = scn.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[k]);



    }



}
