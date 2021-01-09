package com.dataStructure.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] list = {5, 2, 1, 10, 8, 3};
        mergeSort(list, 0, list.length - 1);
        for (int j : list) {
            System.out.print(j + " ");
        }
    }

    public static void mergeSort(int[] list, int leftIndex, int rightIndex) {
        int length = rightIndex - leftIndex + 1;
        int baseIndex = (leftIndex + rightIndex) / 2;
        if (length <= 1) return;

        mergeSort(list, leftIndex, baseIndex);
        mergeSort(list, baseIndex + 1, rightIndex);


        int[] result = new int[length];
        int i = leftIndex;
        int j = baseIndex + 1;
        int k = 0;
        while (i <= baseIndex && j <= rightIndex) {
            if (list[i] < list[j]) {
                result[k++] = list[i++];
                continue;
            }
            if (list[i] > list[j]) {
                result[k++] = list[j++];
                continue;
            }
            result[k++] = list[i++];
            result[k++] = list[j++];
        }
        while (i <= baseIndex) {
            result[k++] = list[i++];
        }
        while (j <= rightIndex) {
            result[k++] = list[j++];
        }
        System.arraycopy(result, 0, list, leftIndex, k);
    }

}
