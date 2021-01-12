package com.dataStructure.search;

import java.util.Scanner;

public class InsertValSearch {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 6};
        System.out.println("Search number: ('q' to quit)");
        String key = null;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            key = scan.next();
            if ("q".equals(key)) {
                System.out.println("END");
                flag = false;
            } else {
                int index = insertValSearch(list, 0, list.length - 1, Integer.parseInt(key));
                if (index != -1) {
                    System.out.println(index);
                } else {
                    System.out.println("Can not find the number. Please change the search num and try again.");
                }
            }
        }
    }


    public static int insertValSearch(int[] list, int left, int right, int searchNum) {
        if (left > right) {
            return -1;
        }
        int midIndex = right - (right - left) * ((list[right] - searchNum)/(list[right] - list[left]));
        if (list[midIndex] > searchNum) {
            return insertValSearch(list, left, midIndex - 1, searchNum);
        } else if (list[midIndex] < searchNum) {
            return insertValSearch(list, midIndex + 1, right, searchNum);
        } else {
            return midIndex;
        }
    }
}
