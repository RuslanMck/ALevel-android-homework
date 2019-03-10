package com.ruslan.aLevel;

import com.ruslan.aLevel.quickSort.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 4, 6, 7, 5, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.printArray(array);
        quickSort.sortArray(array, 0, array.length - 1);
        quickSort.printArray(array);
    }
}
