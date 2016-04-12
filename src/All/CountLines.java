package All;

import java.util.*;

/**
 * Created by Alexandr on 26.12.2015.
 */
public class CountLines {
    private static   class Point{
       int dot;
      boolean l;
        public Point(int dot,boolean l){
            this.dot=dot;
            this.l = l;

        }




        @Override
        public String toString() {
            return  "dot:"+ dot + " "+ "l:"+ l;
        }
    }

    public static  class Point2{
        int l;
        int r;
        public Point2(int l, int r){
            this.l=l;
            this.r=r;
        };

        @Override
        public String toString() {
            return "Point2{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Point[] mass = new Point[n*2];
        List<Point2> list = new ArrayList<Point2>();
        int next;

        for(int i = 0; i<n*2; i++) {
            next = scn.nextInt();
            if (i % 2 == 0) mass[i] = new Point(next,true);
            else mass[i] = new Point(next,false);
            int j  = 1;
            if (i!=0){
            if (i%2!=0) list.add( new Point2(mass[i-1].dot,mass[i].dot));}


            }


        Arrays.sort(mass, new Comparator<Point>() {
            @Override
            public int  compare(Point o1, Point o2) {
                if (o1.dot==o2.dot){

                  if(o1.l==true) return -1;
                 else return 1;
                }

                return  o1.dot-o2.dot;
                //return  o1.dot-o2.dot;
            }

        });
        System.out.println(Arrays.toString(mass));

        int sum = 0;
        int count = 0;


            for (int i = 0; i < n * 2; i++) {
                if (i==0) {count++; continue;}
            if (mass[i].l==true) {
                if( count == 1)  sum+= mass[i].dot-mass[i-1].dot;
                count++;
            }
            if (mass[i].l==false) {
                if(count==1) sum+= mass[i].dot-mass[i-1].dot;
                count --;
            }

            }
        System.out.println(sum);

        }

    }


