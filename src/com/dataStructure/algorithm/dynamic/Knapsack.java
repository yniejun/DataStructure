package com.dataStructure.algorithm.dynamic;


public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3 ,2};
        int[] value = {1500, 3000, 2000, 2200};
        int volume = 4;
        int number = weight.length;
        int[][] max_value = new int[number + 1][volume + 1];
        int[][] path = new int[number + 1][volume + 1];
        for (int i = 1; i <= number; i++) { // includes 0-ith good
            for (int j = 1; j <= volume; j++) { // rest volume of knapsack
                if (weight[i - 1] > j) {
                    max_value[i][j] = max_value[i - 1][j];
                    continue;
                }
                int temp = value[i - 1] + max_value[i - 1][j - weight[i - 1]];
                if (temp > max_value[i - 1][j]) {
                    max_value[i][j] = temp;
                    path[i][j] = 1;
                } else {
                    max_value[i][j] = max_value[i - 1][j];
                }
            }
        }
        System.out.println(max_value[number][volume]);
        int a = path.length - 1;
        int b = path[0].length - 1;
        while (a > 0 && b > 0) {
            if (path[a][b] == 1) {
                System.out.println(a);
                b -= weight[b - 1];
            }
            a--;
        }
    }
}
