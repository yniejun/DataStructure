package com.dataStructure.algorithm;

public class binarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,5,7,9,10,22,55,76};
        System.out.println(search(arr, 76));
    }

    public static int search(int[] arr, int target) {
        int len = arr.length;
        int index = len / 2;
        int start = 0;
        int end = len - 1;
        while (len >= 1) {
            if (target == arr[index]) {
                return index;
            }
            if (target > arr[index]) {
                start = index + 1;
            } else if (target < arr[index]) {
                end = index - 1;
            }
            len = end - start + 1;
            index = start + (len / 2);
        }
        return -1;
    }
}
