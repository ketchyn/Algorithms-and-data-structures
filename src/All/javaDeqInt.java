package All;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Alexandr on 23.12.2015.
 */
public class javaDeqInt extends ArrayDeque {


    public static  boolean arrEquals( Integer[][] a ,Integer[][] b) {
        boolean result = false;
        for(int i =0; i<a.length;i++){
            for(int j = 0; j< 2;j++){
                if(a[i][j].compareTo(b[i][j])==0) result = true;
                else return false;
            }

        }
        return result;
    }



    public static void main(String[] args) {
        ArrayDeque<Integer>  deq = new ArrayDeque<>();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[][] buff = new Integer [n][2];
        Integer[][] result = new Integer [n][2];

        for(int i = 0; i<buff.length; i++){
            for (int j = 0;j<2; j++){
                buff[i][j]=scn.nextInt();
            }
        }

      /*  5
        1 44
        3 50
        2 44
        2 50
        2 -1*/


/*       AA = 1 - push front,
                AA = 2 - pop front,
                AA = 3 - push back,
                AA = 4 - pop back.*/
        for(int i = 0; i<result.length; i++){
            if(buff[i][0]==1){
                deq.addFirst(buff[i][1]);
                result[i][0]=1;
                result[i][1]=buff[i][1];
            }

            if(buff[i][0]==2){
                result[i][0]=2;
                result[i][1]=deq.pollFirst();
                if (result[i][1] ==null) result[i][1] = -1;

            }
            if(buff[i][0]==3){
               deq.addLast(buff[i][1]);
                result[i][0]=3;
                result[i][1]=buff[i][1];

            }

            if(buff[i][0]==4){
                result[i][0]=4;
                result[i][1]= deq.pollLast();
                if (result[i][1] ==null) result[i][1] = -1;

            }

        }


        if (javaDeqInt.arrEquals(result, buff) == true) {
            System.out.println("YES");



        } else System.out.println("NO");


    }

}
