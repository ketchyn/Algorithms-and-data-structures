package SplitAndPower;

import java.util.Scanner;

/**
 * Created by Alexandr on 07.03.2016.
 */
public class binarySearch {
     static int res=-1;

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in AA[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);


        int n = scn.nextInt();
        int[] first = new int[n];
        for(int i = 0; i<n; i++) {
            first[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] second= new int[n2];
        for(int i = 0; i<n2; i++) {
            second[i] = scn.nextInt();
        }

        for (int i =0;i<n2;i++) {
            System.out.print(indexOf(first,second[i])+ " ");
        }

    }
}
