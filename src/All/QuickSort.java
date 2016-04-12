package All;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alexandr on 12.01.2016.
 */
public class QuickSort {

    public static void quickSort(Integer[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex, array);
    }

    private static void doSort(int start, int end, Integer[] array) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, array);
        doSort(cur + 1, end, array);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner scn = new Scanner(new File("input.txt"));
        int n = scn.nextInt();


        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        quickSort(a);
        System.out.println(Arrays.asList(a).toString());
    }
}

