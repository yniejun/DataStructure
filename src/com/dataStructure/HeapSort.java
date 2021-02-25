package com.dataStructure;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 10, 0, 8, 1, 5, 22, 9};
        for (int i = 0; i < arr.length; i++) {
            int len = arr.length - i;
            heapSort(arr, len);
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr, int len) {
        int lastParentIndex = (len - 2) / 2;
        if (lastParentIndex == 0) {
            sort(arr, lastParentIndex, len);
            return;
        }
        sort(arr, lastParentIndex, len);
        heapSort(arr, len - 2 + (len - 1) % 2);
    }

    public static void sort(int[] arr, int index, int len) {
        int temp = arr[index];
        for (int k = index * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[index] = arr[k];
                index = k;
            } else {
                break;
            }
        }
        arr[index] = temp;
    }
}
