package All;

import java.util.*;

/**
 * Created by Alexandr on 24.12.2015.
 */
public class sortInsert {

    public static void insertionSort(Integer[] arr) {
        for(int i = 1; i < arr.length; i++){
            int currElem = arr[i];
            int prevKey = i - 1;
            while(prevKey >= 0 && arr[prevKey] > currElem){
                arr[prevKey+1] = arr[prevKey];
                arr[prevKey] = currElem;
                prevKey--;
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scn = new Scanner(System.in);

       for(int i = 0; i<8;i++){
            list.add(scn.nextInt());
        }
       /* while (scn.hasNextInt()){
            list.add(scn.nextInt());
        }*/
        Collections.sort(list);
        //insertionSort(arr);
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.print(" "+ iter.next());
        }

    }
}
