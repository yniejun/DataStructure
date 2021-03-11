package com.dataStructure.Tree.binaryTree;

public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new TreeNode(1,"a"));
        TreeNode node1 = new TreeNode(3, "b");
        TreeNode node2 = new TreeNode(6, "c");
        TreeNode node3 = new TreeNode(8, "d");
        TreeNode node4 = new TreeNode(10, "e");
        TreeNode node5 = new TreeNode(14, "f");


        tree.rootNode.addLeftNode(node1);
        tree.rootNode.addRightNode(node2);
        node1.addLeftNode(node3);
        node1.addRightNode(node4);
        node2.addLeftNode(node5);

//        System.out.println(node4.getLeftSubNode());
//        System.out.println(node4.getRightSubNode());
//        tree.inThreadedNodes(tree.rootNode);
//        tree.inTraverseThreadedNodes();
        //1 3 8 10 6 14
//        tree.preThreadedNodes(tree.rootNode);
//        tree.preTraverseThreadedNodes();
        //8 10 3 14 6 1
        tree.postThreadedNodes(tree.rootNode);
        tree.postTraverseThreadedNodes(tree.rootNode, 3);
        tree.postTraverseThreadedNodes(tree.rootNode, 3);
        tree.postTraverseThreadedNodes(tree.rootNode, 3);
        tree.postTraverseThreadedNodes(tree.rootNode, 3);
    }
}
