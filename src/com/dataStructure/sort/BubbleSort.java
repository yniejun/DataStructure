package com.dataStructure.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] list = {5, 2, 1, 10, 8, 3};
        int temp;
        boolean flag = true;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
