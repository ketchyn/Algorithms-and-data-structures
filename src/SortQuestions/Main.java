package SortQuestions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Alexandr on 09.03.2016.
 */
 class Main {
static class Point implements Comparable<Point> {
    int l;
    int r;

    public Point(int l, int r) {
        this.l = l;
        this.r = r;
    }


    @Override
    public int compareTo(Point o) {
        if(this.r!=o.r) return this.r - o.r;
        else return this.l - o.l;
    }
}

    static class  PointsAndPosition implements Comparable<PointsAndPosition> {
        int position;
        int point;
        int count;

        public PointsAndPosition(int point, int position) {
            this.position = position;
            this.point = point;
        }

        @Override
        public int compareTo(PointsAndPosition o) {
            return this.point - o.point;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(System.in);
        int OtrCount = scn.nextInt();
        int pointCount = scn.nextInt();
        Point[] otr = new Point[OtrCount];
        TreeMap<Integer, PointsAndPosition> positionToPoint = new TreeMap<>();
        for( int i = 0; i<OtrCount;i++){
            otr[i] = new Point(scn.nextInt(), scn.nextInt());
        }
       PointsAndPosition[] points = new PointsAndPosition[pointCount];
        for( int i = 0; i<pointCount;i++){
            points[i] = new PointsAndPosition(scn.nextInt(),i);
            positionToPoint.put(i, points[i]);
        }


        Arrays.sort(otr);
        Arrays.sort(points);
        int j = 0;
        int position=0;
        for(int i = 0; i<points.length;i++){
            j=position;
            int currentDot = points[i].point;
            while (j<otr.length&&otr[j].r< currentDot ){
                j++;
            }
            position=j;
            while (j<otr.length&&currentDot<=otr[j].r) {
                if(otr[j].l<=currentDot&&currentDot<=otr[j].r){
                    points[i].count++;
                }
                j++;
            }

        }
        Arrays.sort(points, new Comparator<PointsAndPosition>() {
            @Override
            public int compare(PointsAndPosition o1, PointsAndPosition o2) {
                return o1.position - o2.position;
            }
        });

        for(int i = 0;i<points.length;i++) {
            positionToPoint.put(points[i].position, points[i]);
            System.out.print(positionToPoint.get(i).count+ " " );
        }


    }
}
