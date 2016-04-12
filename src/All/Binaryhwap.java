package All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexandr on 23.12.2015.
 */
public class Binaryhwap {

  List<Integer> list = new ArrayList<>();
    public int heapSize(){
        return list.size();
    }

    public void add(int value)
    {

        int i = heapSize() - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && list.get(parent) < list.get(i))
        {
            int temp = list.get(i);
            list.set(i,list.get(parent));
            list.set(parent,temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }
    public void heapify(int i)
    {
        int leftChild;
        int rightChild;
        int largestChild;

        for (; ; )
        {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize() && list.get(leftChild) > list.get(largestChild))
            {
                largestChild = leftChild;
            }

            if (rightChild < heapSize() && list.get(rightChild) > list.get(largestChild))
            {
                largestChild = rightChild;
            }

            if (largestChild == i)
            {
                break;
            }

            int temp = list.get(i);
            list.set(i,list.get(largestChild));
            list.set(largestChild, temp);
            i = largestChild;
        }
    }


    public void buildHeap(Integer[] sourceArray)
    {
        list = Arrays.asList(sourceArray);
        for (int i = heapSize() / 2; i >= 0; i--)
        {
            heapify(i);
        }
    }

    public int getMax()
    {
        int result = list.get(0);
       this.list.set(0,list.get(heapSize()-1));
        this.list.remove(heapSize()-1);
        heapify(0);
        return result;

    }


    public static void main(String[] args) {
        Binaryhwap heap = new Binaryhwap();
        Integer[] mass = {1, 8, 9, 12, 15, 14, 17, 13};
        heap.buildHeap(mass);
        int i = 0;
        System.out.println(int.class.getName());


        //System.out.println(heap.getMax());
       // System.out.println(heap.heapSize());

       // System.out.println(heap.list.toString());

      /* for(int i = 0 ;i<heap.list.size(); i++) {
           System.out.println("i :"+ i+ " element : " +heap.list.get(i));

       }*/


      List<Integer> r = new ArrayList<>( Arrays.asList(mass) );
        System.out.println(r.getClass().getName());
        System.out.println(r.get(3));
        System.out.println(r.remove(3));


       // System.out.println(r.toString());

      //  System.out.println(heap.getMax());




    }


}
