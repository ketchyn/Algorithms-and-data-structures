package DynemicPrograming;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexandr on 12.03.2016.
 */
public  class shortDistan {
    int ins;
    int sub;
    int del;
    int[][] d;
    int n;
    int m;

    public int EditDistTd(int i ,int j, char[] B, char[] A) {
      //  while(i>=0) {
        //    while (j >= 0) {

        if (i == 0) return  j;
        if (j == 0) return  i;
        if (d[i][j] != Integer.MAX_VALUE) {
                    return d[i][j];
                }
                  //  else {
                        ins = EditDistTd(i, j - 1, B, A) + 1;
                       del = EditDistTd(i - 1, j, B, A) + 1;
                        sub = EditDistTd(i - 1, j - 1, B, A) + diff(A[j-1], B[i-1]);
                        d[i][j] = Math.min(Math.min(ins,del),sub);
                   // }

                return d[i][j];
         //   }

       // }
        //return -9;

    }

    public int min(int a, int b, int c) {
        if (a <= b && a <= c) return a;
        if (b <= a && b <= c) return b;
        if (c <= b && c <= a) return c;
        return Integer.MAX_VALUE;
    }
    public int diff(char i, char j) {
        if (i==j) return 0;
        else return 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(System.in);
        String Aor;
        String Bor;
        int m = 0;
        int n = 0;
            Aor = scn.next();
             Bor = scn.next();
        shortDistan ex = new shortDistan();
        if(Aor.length()<=Bor.length()){

             n= Bor.length();
             m=Aor.length();
        } else {
              n = Bor.length();
             m = Aor.length();
        }
        ex.d = new int[n+1][m+1];


        for (int i = 0; i<n+1;i++) {
            for(int j =0; j<m+1;j++) {
                ex.d[i][j] = Integer.MAX_VALUE;
            }
        }
        char[] A = Aor.toCharArray();
        char[] B = Bor.toCharArray();
        int res = ex.EditDistTd(n, m, B, A);


        System.out.println(res);


        int a = 7;

    }
}
