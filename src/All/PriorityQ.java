package All;

import java.io.IOException;
import java.util.*;

/**
 * Created by Alexandr on 22.12.2015.
 */
public class PriorityQ {
    public static int countSteps( PriorityQueue<Integer> bucket, int k){


        List<Integer> toEat = new ArrayList<>();
      //  List<Integer> returns = new ArrayList<>();
        int steps = 0;
        int fruitToReturn;
        while(bucket.isEmpty()==false) {
            toEat.clear();

            int count = bucket.poll();
            while (count > k) {
                count = bucket.poll();
            }
            //toEat.add

            int fruit = count;
            toEat.add(fruit);

            if (bucket.peek()!=null) {
                while (bucket.peek()!=null&&count+bucket.peek() <= k) {
                    fruit=bucket.poll();
                    count = count + fruit;
                    toEat.add(fruit);
                }
            }

            steps++;
            Iterator<Integer> iter = toEat.iterator();
            while (iter.hasNext()){
                fruitToReturn=iter.next();
                if( fruitToReturn>1){
                    if(fruitToReturn%2==0){
                        bucket.add(fruitToReturn/2);
                    }else bucket.add(fruitToReturn/2);
                }


            }



        }


        return steps;
    }




    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> bucket = new PriorityQueue<>(Collections.reverseOrder());
       Scanner scn = new Scanner(System.in);
        int n =0;
        n = scn.nextInt();
        int[] mass = new int[n];
        for(int i = 0; i<mass.length; i++){
          mass[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.in.close();

        for(int i = 0; i<mass.length; i++){
           bucket.add(  mass[i]);
        }








        System.out.println(countSteps(bucket,k));

// n 3  k 6 [4 3 5]

    }


}
