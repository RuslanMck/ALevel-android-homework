package com.ruslan.aLevel.quickSort;

public class QuickSort {
    public void sortArray(int[] array, int low, int high) {
        int l = low;
        int h = high;
        int pivot = array[(low + high) / 2];

        while(l <= h) {
            while(array[l] < pivot) {
                ++l;
            }

            while(array[h] > pivot) {
                --h;
            }

            if (l <= h) {
                int temp = array[l];
                array[l] = array[h];
                array[h] = temp;
                ++l;
                --h;
            }
        }

        if (low < h) {
            this.sortArray(array, low, h);
        }

        if (l < high) {
            this.sortArray(array, l, high);
        }
    }

    public void printArray(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}