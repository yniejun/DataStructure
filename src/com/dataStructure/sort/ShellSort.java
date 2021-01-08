package com.dataStructure.sort;


public class ShellSort {
    public static void main(String[] args) {
        int[] list = {5, 2, 1, 10, 8, 3};;
        shellSort(list);
//        shellSorte(list);
    }

    public static void shellSort(int[] list) {
        for (int step = list.length / 2; step > 0; step /= 2) {
            for (int j = step; j < list.length; j++) {
                int index = j;
                int val = list[index];
                while (index - step >= 0 && val < list[index - step]) {
                    list[index] = list[index - step];
                    index -= step;
                }
                list[index] = val;
            }
        }


        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

    }

    private static void shellSorte(int[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值。
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
