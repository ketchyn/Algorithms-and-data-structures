package All;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by Alexandr on 16.12.2015.
 */
public class Ex2 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter n");
         int n = scn.nextInt();


        if (n >= 1 && n <= 100000) {
            int[] A = new int[n];
            int[] B = new int[n];
            int Ael;
            int Bel;



            System.out.println("entr element mass 1");
            for (int i = 0; i < A.length; i++) {
                    A[i] = scn.nextInt();
                if (A[i] > 100000) {
                    System.in.close();
                }
            }
            System.out.println("entr element mass 2");

            for (int j = 0; j < B.length; j++) {
                    B[j] = scn.nextInt();
                if (B[j] > 100000) {
                    System.in.close();

                }
            }
            System.in.close();
             int outI = 0;
            int outJ = 0;

            int sum = Integer.MIN_VALUE;
            int maxA = Integer.MIN_VALUE;




    /*       for (int i = 0; i < A.length; i++) {

                for (int j = i; j < B.length; j++) {
                   // if (i <= j) {
                        current = A[i] + B[j];
                        if (current > sum) {
                            sum = current;
                            outJ=j;
                            outI=i;
                        }
                    //}

                }

            }*/


            for (int i = 0; i < B.length; i++) {
                if (i >= 1) {
                   A[i] = max(A[i],A[i - 1]);
                }
                if ((B[i] + A[i]) > sum)
                {
                    sum = B[i] + A[i];
                    outJ = i;
                }
            }
                for (int i = 0;  i<=outJ ; i++){
                    if (A[i]>maxA){maxA = A[i]; outI = i;}
                }


            System.out.println(outI + " " + outJ);


        }

    }

}


