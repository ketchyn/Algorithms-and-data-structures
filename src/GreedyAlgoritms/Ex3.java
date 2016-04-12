package GreedyAlgoritms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alexandr on 06.03.2016.
 */
public class Ex3 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dif;

        List<Integer> list = new ArrayList<>();
       for(int i = 1; i<=n;i++) {
           list.add(i);
       }
        List<Integer> listRes = new ArrayList<>();

        int i = 0;
       // listRes.add(1);
        int currentSum = 0;
        while ( i<n){

          /*  if (n == 2) {
                listRes.add(2);
                break;
            }
            if (n == 5) {
                listRes.add(2);
                listRes.add(5);
                break;
            }*/

            dif = n - (list.get(i) + currentSum);
            if (!listRes.contains(dif)/*!(dif<=currentSum)*/&&dif>0&&dif!=list.get(i)){
                listRes.add(list.get(i));
                currentSum = list.get(i) + currentSum;
                i++;

        }
            else {
                if(dif>0) i++;
                else {
                    listRes.add(list.get(i));
                    break;
                }
            }
        }
        System.out.println(listRes.size());
       for(int j = 0 ;j<listRes.size(); j++) {

           System.out.print(listRes.get(j)+ " " );
       }
    }
}
