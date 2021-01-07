package com.dataStructure.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] list = {5, 2, 1, 10, 8, 3};
        boolean flag = true;
        for (int j = 0; j < list.length - 1; j++) {
            int minNo = j;
            for (int i = j + 1 ; i < list.length; i++) {
                if (list[i] < list[minNo]) {
                    minNo = i;
                    flag = false;
                }
            }
            if (!flag){
                int temp;
                temp = list[j];
                list[j] = list[minNo];
                list[minNo] = temp;
            } else {
                break;
            }

        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
