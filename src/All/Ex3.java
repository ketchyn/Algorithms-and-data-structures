package All;

/**
 * Created by Alexandr on 17.12.2015.
 */
public class Ex3 {
/*
    public static int binarysearch(int x, int arr[]) {
        int l = 0;
        int r = arr.length - 1;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            //делим отрезок [l,r] пополам
            if (arr[mid] < x) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if( arr[l]==x) return l;
        if (arr[r]==x) return r;

        return -1;




    }*/
    public static int binarysearch(int x, int arr[]) {
        int first = 0;
        int last  = arr.length - 1;
        while (first<=last) {
            int mid = (first + last) / 2;
            //делим отрезок [l,r] пополам
            if (arr[mid]==x)  return mid;
            else
            if (x<arr[mid]) last = mid-1;
            else
            if (x>arr[mid]) first = mid + 1;

        }
        return -1;
    }

        //цикл нужен, чтобы не править код
        //в случае увелечения интервала
        //[l,r]

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        System.out.println( Ex3.binarysearch(9,arr));
        System.out.println( "ssss");

}
        }
