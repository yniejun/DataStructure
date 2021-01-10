package com.dataStructure.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] list = {599, 28, 109, 127, 218, 3};
        radixSort(list);
        for (int j : list) {
            System.out.print(j + " ");
        }
    }

    public static void radixSort(int[] list) {
        int bucketIndex;
        int[] innerIndex = new int[10];
        int bucketNum = 1;
        int i;
        do {
            int[][] bucket = new int[10][list.length];
            for (int e : list) {
                bucketIndex = e / bucketNum % 10;
                bucket[bucketIndex][innerIndex[bucketIndex]++] = e;
            }
            int index = 0;
            for (i = 0; i < 10; i++) {
                for (int j = 0; j < list.length; j++) {
                    if (bucket[i][j] != 0) {
                        list[index++] = bucket[i][j];
                    }
                }
                if (index == list.length) {
                    break;
                }
            }
            bucketNum *= 10;
            Arrays.fill(innerIndex, 0);
        } while (i != 0);
    }
}