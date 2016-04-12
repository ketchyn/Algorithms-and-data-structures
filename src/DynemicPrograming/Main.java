package DynemicPrograming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alexandr on 09.03.2016.
 */
public class Main {

    public static int[] LISButtomUp(int[] arr) {
        int[] res = new int[arr.length];
        for(int i = 0;i<arr.length; i++)
        {
            res[i]=1;
          //  for(int j =0;j<=i-1;j++) {
             //  if (arr[j] >=arr[i] && res[j] + 1 > res[i]/*&&arr[i]%arr[j]==0*/) {
                 //   res[i] = res[j]+1;
              //  }
          //  }
            int j = 0;
            while (j <= i - 1) {

                  if (arr[j] >=arr[i] && res[j] + 1 > res[i]/*&&arr[i]%arr[j]==0*/) {
                   res[i] = res[j]+1;
                  }


            }
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] initMass = new int[n];
        for(int i = 0;i<n; i++) {
            initMass[i] = scn.nextInt();
        }
        int[] a = {7,2,1,3,8,4,9,1,2,6,5,9,3,8,1};
        //int[] b = {9,9,9,9,9,9,9,9};
        int[] resoFIndex = LISButtomUp(initMass);

        int max = Integer.MIN_VALUE;
        int indexOfMax=0;
        for(int i = 0; i<resoFIndex.length;i++) {
            if (resoFIndex[i] > max) {
                max = resoFIndex[i];
                indexOfMax = i;
            }
        }
        int[] resOFeL = new int[max];
        System.out.println(max);
        int j = resOFeL.length-1;
        int prevMax = 0 ;
        for(int i =indexOfMax ; i>=0;i--) {


            if (resoFIndex[i] == max) {

                if (j>=0) {
                    resOFeL[j] = i+1;
                    j--;

                }



               // prevMax = max;
                max--;
        }
        }

        for(int i = 0; i<resOFeL.length;i++) {
            System.out.print(resOFeL[i] + " ");
        }








    }
}
