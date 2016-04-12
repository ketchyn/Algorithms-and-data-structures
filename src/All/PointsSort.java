package All;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Alexandr on 25.12.2015.
 */
public class PointsSort implements Comparable<PointsSort> {

     int x;
    int y ;

    public PointsSort(int x, int y) {
        this.x = x;
        this.y = y;
    }

      /*  @Override
        public int compare(PointsSort o1, PointsSort o2) {
           if (o1.x-o2.x==0)  return o1.y-o2.y;
            return o1.x-o2.y;
        }*/

        @Override
        public int compareTo(PointsSort o) {
            if (this.x-o.x==0)  return this.y-o.y;
            return this.x-o.x;
        }

    @Override
    public String toString() {
        return x +  " " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointsSort that = (PointsSort) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public static void main(String[] args) {
        Set<PointsSort> tree =new TreeSet<>();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i = 0; i<n; i++) {
            tree.add( new PointsSort(scn.nextInt(),scn.nextInt()));
        }
        Iterator iter = tree.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }

    }


}
/*0 0*/
/*1 1*/
/*1 0*/
/*
0 1*/
