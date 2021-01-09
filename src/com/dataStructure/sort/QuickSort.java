package com.dataStructure.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = {5, 2, 1, 10, 8, 3};
        quickSort(list, 0, 5);
        for (int j : list) {
            System.out.print(j + " ");
        }
    }

    public static void quickSort(int[] list, int leftIndex, int rightIndex) {
        int len = rightIndex - leftIndex + 1;
        if (len <= 1) return;
        int baseIndex = leftIndex + len / 2;
        int leftFromBase = leftIndex - baseIndex;
        int rightFromBase = rightIndex - baseIndex;
        do {
            while (leftFromBase < 0 && list[baseIndex + leftFromBase] < list[baseIndex]) {
                leftFromBase++;
            }
            while (rightFromBase > 0 && list[baseIndex + rightFromBase] > list[baseIndex]) {
                rightFromBase--;
            }
            if (rightFromBase != 0 || leftFromBase != 0) {
                int temp = list[baseIndex + leftFromBase];
                list[baseIndex + leftFromBase] = list[baseIndex + rightFromBase];
                list[baseIndex + rightFromBase] = temp;
                if (rightFromBase == 0) {
                    baseIndex += leftFromBase;
                    leftFromBase = leftIndex - baseIndex;
                }
                if (leftFromBase == 0) {
                    baseIndex += rightFromBase;
                    rightFromBase = rightIndex - baseIndex;
                }
            }
        } while (leftFromBase != rightFromBase);
        if (baseIndex - leftIndex > 0) {
            quickSort(list, leftIndex, baseIndex - 1);
        }
        if (rightIndex - baseIndex - 1 > 0) {
            quickSort(list, baseIndex + 1, rightIndex);
        }
    }
}
