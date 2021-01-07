package com.dataStructure.sort;

import java.util.LinkedList;

public class InsertSort {
    public static void main(String[] args) {
        int[] list1 = {5, 2, 1, 10, 8, 3};
        int[] list2 = {5, 2, 1, 10, 8, 3};
        listInsertSort(list1);
        linkedListInsertSort(list2);
    }

    public static void listInsertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int shiftIndex = i - 1;
            int insertVal = list[i];
            while (shiftIndex >= 0 && insertVal < list[shiftIndex]) {
                list[shiftIndex + 1] = list[shiftIndex];
                shiftIndex--;
            }
            if (shiftIndex + 1 != i) {
                list[shiftIndex + 1] = insertVal;
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void linkedListInsertSort(int[] list) {
        LinkedList<Integer> a = new LinkedList<>();
        a.add(list[0]);
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] < a.get(j)) {
                    a.add(j, list[i]);
                    break;
                }
                if (j == i - 1) {
                    a.add(i, list[i]);
                }
            }
        }
        System.out.println(a);
    }
}
