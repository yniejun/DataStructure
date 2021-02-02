package com.dataStructure.search;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6};
        System.out.println("Search number: ('q' to quit)");
        String key;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            key = scan.next();
            if ("q".equals(key)) {
                System.out.println("END");
                flag = false;
            } else {
                int index = fibonacciSearch(list, 0, list.length - 1, Integer.parseInt(key));
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("Can not find the number. Please change the search num and try again.");
                }
            }
        }
    }

    public static int fibonacciSearch(int[] list, int left, int right, int searchNum){
        if (left > right) {
            return -1;
        }
        int midIndex = fibonacciIndex(list);
        if (list[midIndex] > searchNum) {
            return fibonacciSearch(list, left, midIndex - 1, searchNum);
        } else if (list[midIndex] < searchNum) {
            return fibonacciSearch(list, midIndex + 1, right, searchNum);
        } else {
            return midIndex;
        }
    }

    public static int[] fibonacci(int max){
        int[] f = new int[max];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1] + f[i-3];
        }
        return f;
    }

    public static int fibonacciIndex(int[] a){
        int low = 0;
        int high =  a.length;
        int mid = 0;
        int k = 0;
        int[] f = fibonacci(20);
        while(high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = a[high];

        }
        while(low <= high){
            mid = low + f[k-1] - 1;
        }
        return mid;
    }
}
