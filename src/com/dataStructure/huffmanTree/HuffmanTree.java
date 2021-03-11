package com.dataStructure.huffmanTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        TreeNode root = createHuffmanTree(arr);
        root.preorder();
    }

    private static TreeNode createHuffmanTree(int[] arr) {
        // create collections from list
        List<TreeNode> list = new ArrayList<>();
        for (int weight :
                arr) {
            list.add(new TreeNode(weight));
        }

        while (list.size() > 1) {
            // sort the list
            Collections.sort(list);

            // get two smallest weight
            TreeNode left = list.get(0);
            TreeNode right = list.get(1);

            // combine two smallest node to a new node
            TreeNode parent = new TreeNode(left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            // remove old node and add new node
            list.remove(left);
            list.remove(right);
            list.add(parent);

            // repeat
        }
        return list.get(0);
    }
}

class TreeNode implements Comparable<TreeNode> {
    public int weight;
    TreeNode left;
    TreeNode right;

    public TreeNode(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "weight=" + weight +
                '}';
    }


    // ASC
    @Override
    public int compareTo(TreeNode o) {
        return this.weight - o.weight;
    }

    // preorder
    public void preorder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }
}
