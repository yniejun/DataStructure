package com.dataStructure.Tree.binaryTree;

public class TreeNode {
    public int id;
    public String val;
    public TreeNode leftSubNode;
    public TreeNode rightSubNode;
    // 0: normal 1:threaded
    private int leftType;
    private int rightType;

    public TreeNode(int id, String val) {
        this.id = id;
        this.val = val;
    }

    public TreeNode getLeftSubNode() {
        return leftSubNode;
    }

    public void setLeftSubNode(TreeNode leftSubNode) {
        this.leftSubNode = leftSubNode;
    }

    public TreeNode getRightSubNode() {
        return rightSubNode;
    }

    public void setRightSubNode(TreeNode rightSubNode) {
        this.rightSubNode = rightSubNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public void addLeftNode(TreeNode newNode) {
        leftSubNode = newNode;
    }

    public void addRightNode(TreeNode newNode) {
        rightSubNode = newNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", val='" + val + '\'' +
                '}';
    }

    public void preorder() {
        System.out.println(this);
        if (leftSubNode != null) {
            leftSubNode.preorder();
        }
        if (rightSubNode != null) {
            rightSubNode.preorder();
        }
    }

    public void inorder() {
        if (leftSubNode != null) {
            leftSubNode.inorder();
        }
        System.out.println(this);
        if (rightSubNode != null) {
            rightSubNode.inorder();
        }
    }

    public void postorder() {
        if (leftSubNode != null) {
            leftSubNode.postorder();
        }
        if (rightSubNode != null) {
            rightSubNode.postorder();
        }
        System.out.println(this);
    }

    public void preorderQuery(int id) {
        if (this.id == id) {
            System.out.println(this);
            return;
        }
        if (this.rightSubNode != null) {
            this.rightSubNode.preorderQuery(id);
        }
        if (this.leftSubNode != null) {
            this.leftSubNode.preorderQuery(id);
        }
    }

    public void delNode(int id) {
        if (this.id == id) {
            System.out.println("Can not delete root node");
            return;
        }
        if (this.leftSubNode != null) {
            if (this.leftSubNode.id == id) {
                this.leftSubNode = null;
                System.out.println("Deleted");
                return;
            }
            this.leftSubNode.delNode(id);
        }

        if (this.rightSubNode != null) {
            if (this.rightSubNode.id == id) {
                this.rightSubNode = null;
                System.out.println("Deleted");
                return;
            }
            this.rightSubNode.delNode(id);
        }
        System.out.println("Can not delete nonexistent node");

    }
}
