package DynemicPrograming;

/**
 * Created by Alexandr on 10.03.2016.
 */
public class MainNew {
    //static int[] AA;
    static int startIndex;
    static int maxLength;

    static int findMaxIncrSubseq(int[] a ) {
        if (a.length == 1) {
            startIndex = 0;
            maxLength = 1;
            return -1;
        }
        int start = startIndex = 0;
        int length = maxLength = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = start;
                }
                length = 1;
                start = i;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {7,2,1,3,8,4,9,1,2,6,5,9,3,8,1};
      int RES =  findMaxIncrSubseq(a);

    }
}
