package DynemicPrograming;

/**
 * Created by Alexandr on 12.03.2016.
 */
public class Rukzak {

    public static int fill(int W,int[] wi, int[] ci ) {
        int[] d = new int[W+1];
        for(int w=1;w<=W; w++) {
            for (int i = 0;i<wi.length;i++ ) {
                if (wi[i] <= w) {
                    d[w] = Math.max(d[w], d[w - wi[i]] + ci[i]);
                }
            }
        }
        return d[W];
    }

    public static void main(String[] args) {
        int[] wi = {6, 3, 4, 2};
        int[] ci = {30,14,16,9};
        int res = fill(10, wi, ci);
        System.out.println(res);

    }
}
