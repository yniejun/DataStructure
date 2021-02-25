package com.dataStructure.binaryTree;

public class SequentialPresentationBT {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        SequentialTree sequentialTree = new SequentialTree(arr);
        sequentialTree.preorder(0);
    }
}

class SequentialTree {
    private int[] arr;

    public SequentialTree(int[] arr) {
        this.arr = arr;
    }

    public void preorder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("Empty tree");
        }
        System.out.println(arr[index]);
        int left = 2 * index + 1;
        if (left < arr.length) {
            preorder(left);
        }
        int right = 2 * index + 2;
        if (right < arr.length) {
            preorder(right);
        }
    }
}
