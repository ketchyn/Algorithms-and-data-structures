package All;

import java.util.Scanner;

/**
 * Created by Alexandr on 17.12.2015.
 */
public class Ex4 {
    public static int binarysearch(Double x, int arr[]) {
        int first = 0;
        int last  = arr.length - 1;
        if (x<arr[0]) return 0;
        if (x>arr[arr.length-1]) return arr.length-1;
        if(x ==arr[arr.length-1] ) return  arr.length-1;
        if(x ==arr[0] ) return  0;

        while (first<=last) {
            int mid = (first + last) / 2;
            //делим отрезок [l,r] пополам
            if (arr[mid]==x)  {
                return mid;
               /* if(x-arr[mid-1]>(arr[mid+1])){
                    return mid+1;
                } else  return mid-1;*/
            }
            else
            if (x<arr[mid]) last = mid-1;
            else
            if (x>arr[mid]) first = mid + 1;

        }

        if (x-arr[last]>(arr[last+1]-x)){
            return last+1;
        }

        return last;
    }
    public static void main(String[] args)  {

        Scanner scn = new Scanner(System.in);
        System.out.println("n");
        int n = scn.nextInt();
        int[] a =  new int[n];
        System.out.println("enter AA elements");
        for(int i = 0; i< a.length;i++){
            a[i]= scn.nextInt();
        }
        System.out.println("k");
        int k = scn.nextInt();
        double[] b =new double[k];
        System.out.println("enter b elements");

        for(int i = 0; i< b.length;i++){
            b[i]= Double.parseDouble(scn.next());
        }
        int[] buffA  = {10,20,30};
        double[] buffB = {9,15,35};
       // if ((Arrays.equals(buffA,AA) == false)&&(Arrays.equals(buffB,b) == false)) {
            //throw new Exception("AA= "+ Arrays.toString(AA)+ "b= "+  Arrays.toString(b));
          //  System.out.println( "AA= "+ Arrays.toString(AA)+ "b= "+  Arrays.toString(b));
       // }


        for (int i = 0; i< b.length;i++) {
            System.out.print(  Ex4.binarysearch(b[i],a)+" ");


        }

        // throw new Exception( Arrays.toString(AA)+ " "  + Arrays.toString(b) );
    }

}

