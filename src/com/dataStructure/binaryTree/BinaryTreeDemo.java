package com.dataStructure.binaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new TreeNode(1,"a"));
        TreeNode node1 = new TreeNode(2, "b");
        TreeNode node2 = new TreeNode(3, "c");
        TreeNode node3 = new TreeNode(4, "d");
        TreeNode node4 = new TreeNode(5, "e");

        tree.rootNode.addLeftNode(node1);
        tree.rootNode.addRightNode(node2);
        node2.addRightNode(node3);
        node2.addLeftNode(node4);
    }
}

