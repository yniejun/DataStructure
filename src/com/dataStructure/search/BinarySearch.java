package com.dataStructure.search;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {1, 2, 5, 5, 5, 5, 5, 9, 10, 15};
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
                ArrayList<Integer> index = binarySearch(list, 0, list.length - 1, Integer.parseInt(key));
                if (!index.isEmpty()) {
                    System.out.println(index);
                } else {
                    System.out.println("Can not find the number. Please change the search num and try again.");
                }
            }
        }
    }


    public static ArrayList<Integer> binarySearch(int[] list, int left, int right, int searchNum) {
        ArrayList<Integer> rtn = new ArrayList<>();
        if (left > right) {
            return rtn;
        }
        int midIndex = (left + right) / 2;
        if (list[midIndex] > searchNum) {
            return binarySearch(list, left, midIndex - 1, searchNum);
        } else if (list[midIndex] < searchNum) {
            return binarySearch(list, midIndex + 1, right, searchNum);
        } else {
            rtn.add(midIndex);
            int temp = midIndex - 1;
            while (temp > left && list[temp] == searchNum) {
                rtn.add(temp);
                temp--;
            }
            temp = midIndex + 1;
            while (temp < right && list[temp] == searchNum) {
                rtn.add(temp);
                temp++;
            }
            return rtn;
        }
    }
}
