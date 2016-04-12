package DynemicPrograming;

import java.util.Scanner;

/**
 * Created by Alexandr on 13.03.2016.
 */
public class RukzakBezPovtorov {
    public static int fill(int W, int[] wi, int[] ci) {
        int n = wi.length + 1;
        int[][] d = new int[W+1][wi.length + 1];
        for (int w = 0; w <= W; w++) {
            d[w][0] = 0;

        }
        for (int i = 0; i < n; i++) {
            d[0][i] = 0;

        }

        for (int i = 1; i < n; i++) {

            for (int w = 1; w < W+1; w++) {
                d[w][i] = d[w][i - 1];
                if (wi[i - 1] <= w) {
                    d[w][i] = Math.max(d[w][i], d[w - wi[i - 1]][i - 1] + ci[i - 1]);
                }

            }


        }

        return d[W][n-1];


    }

    public static void main(String[] args) {
        int[] wi = {6, 3, 4, 2};
        int[] ci = {30,14,16,9};

        int res = fill(10, wi, ci);
        System.out.println(res);
       /* Scanner scn = new Scanner(System.in);
        int W = scn.nextInt();
        int n = scn.nextInt();
        int[] wi = new int[n];

        for( int i = 0; i<n; i++) {
            wi[i] = scn.nextInt();
        }
        int res = fill(W, wi);
        System.out.println(res);
*/
    }


}
