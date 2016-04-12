package GreedyAlgoritms;

import java.util.Scanner;

/**
 * Created by Alexandr on 05.03.2016.
 */
public class Ex1 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Point[] point = new Point[n];
        for(int i = 0;i<n;i++) {
            point[i] = new Point(scn.nextInt(), scn.nextInt());
        }

    int count = 0;
        String  po = "";



        for(int i = 0;i<point.length;i++) {
            if (i>0){
                if(point[i].l<=point[i-1].r){
                    int j = i;

                        while(j<point.length&&(point[j].l<=point[i-1].r)){
                             j++;
                         }

                    count++;
                    po +=  point[i-1].r+" ";
                    i=j-1;
                }else count++;
            }

        }
        System.out.println(count);
        System.out.println(po);
    }

    static class Point{
        int  l;
        int r ;
        public Point( int l, int r) {
            this.l=l;
            this.r=r;
        }
    }

}





