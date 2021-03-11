package com.dataStructure.Tree.binaryTree;

import java.util.Stack;

public class BinaryTree {
    private final int NORMAL = 0;
    private final int THREAD = 1;
    public TreeNode rootNode;
    // previous node of the threaded node
    private TreeNode preNode = null;

    public BinaryTree(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public void preorder() {
        if (this.rootNode != null) {
            this.rootNode.preorder();
        } else {
            System.out.println("empty tree");
        }
    }


    public void inorder() {
        if (this.rootNode != null) {
            this.rootNode.inorder();
        } else {
            System.out.println("empty tree");
        }
    }


    public void postorder() {
        if (this.rootNode != null) {
            this.rootNode.postorder();
        } else {
            System.out.println("empty tree");
        }
    }


    public void preorderQuery(int id) {
        if (this.rootNode != null) {
            this.rootNode.preorderQuery(id);
        } else {
            System.out.println("empty tree");
        }
    }


    public void delNode(int id) {
        if (this.rootNode != null) {
            this.rootNode.delNode(id);
        } else {
            System.out.println("empty tree");
        }
    }


    // inorder threaded
    public void inThreadedNodes(TreeNode node) {
        if (node != null) {
            // thread left node
            inThreadedNodes(node.getLeftSubNode());
            // thread root node
            if (node.getLeftSubNode() == null) {
                node.setLeftSubNode(preNode);
                node.setLeftType(THREAD);
            }
            if (preNode != null) {
                if (preNode.getRightSubNode() == null) {
                    preNode.setRightSubNode(node);
                    preNode.setRightType(THREAD);
                }
            }
            preNode = node;
            // thread right node
            inThreadedNodes(node.getRightSubNode());

        } else {
            System.out.println("Node not existed");
        }
    }


    public void inTraverseThreadedNodes() {
        TreeNode node = rootNode;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeftSubNode();
            }
            System.out.println(node);
            while (node.getRightType() == THREAD) {
                node = node.getRightSubNode();
                System.out.println(node);
            }
            node = node.getRightSubNode();
        }
    }


    // preorder threaded
    public void preThreadedNodes(TreeNode node) {
        if (node != null) {
            // thread root node
            if (node.getLeftSubNode() == null) {
                node.setLeftSubNode(preNode);
                node.setLeftType(THREAD);
            }
            if (preNode != null && preNode.getRightSubNode() == null) {
                preNode.setRightSubNode(node);
                preNode.setRightType(THREAD);
            }
            preNode = node;
            // thread left node
            if (node.getLeftType() != THREAD) {
                preThreadedNodes(node.getLeftSubNode());
            }
            // thread right node
            if (node.getRightType() != THREAD) {
                preThreadedNodes(node.getRightSubNode());
            }

        } else {
            System.out.println("Node not existed");
        }
    }


    public static void preRootTravel(TreeNode root){
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while(root != null) {
                    System.out.print(root.val);
                    stack.push(root);
                    root = root.leftSubNode;
                }
                root = stack.pop().rightSubNode;
            }
        }
    }


    public void preTraverseThreadedNodes() {
        TreeNode node = rootNode;
        while (node != null) {
            System.out.println(node);
            while (node.getLeftType() == 0) {
                node = node.getLeftSubNode();
                System.out.println(node);
            }

            while (node.getRightType() == THREAD) {
                node = node.getRightSubNode();
                System.out.println(node);
            }
            node = node.getRightSubNode();
        }
    }


    // postorder threaded
    public void postThreadedNodes(TreeNode node) {
        if (node != null) {
            // thread left node
            postThreadedNodes(node.getLeftSubNode());
            // thread right node
            postThreadedNodes(node.getRightSubNode());

            // thread root node
            if (node.getLeftSubNode() == null) {
                node.setLeftSubNode(preNode);
                node.setLeftType(THREAD);
            }
            if (preNode != null && preNode.getRightSubNode() == null) {
                preNode.setRightSubNode(node);
                preNode.setRightType(THREAD);
            }
            preNode = node;
        } else {
            System.out.println("Node not existed");
        }
    }


    public void postTraverseThreadedNodes(TreeNode node, int type) {
        if (node != null) {
            if (node.getLeftType() == NORMAL) {
                postTraverseThreadedNodes(node.getLeftSubNode(),1);
            }
            if (node.getRightType() == NORMAL) {
                postTraverseThreadedNodes(node.getRightSubNode(),2);
            }
            if (type != 2){
                System.out.println(node);
            }
            while (node.getRightType() == THREAD) {
                node = node.getRightSubNode();
                if (node.getRightType() ==  THREAD){
                    System.out.println(node);
                }
            }
        }
    }
}
