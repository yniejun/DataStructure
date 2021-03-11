package com.dataStructure.Tree.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int value:
             arr) {
            binarySortTree.add(new TreeNode(value));
        }
        binarySortTree.inorder();

        System.out.println("after:");
        binarySortTree.del(10);
        binarySortTree.inorder();
    }

}

class BinarySortTree {
    private TreeNode root;

    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void inorder() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            root.inorder();
        }
    }

    public void del(int value) {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            root.del(value);
        }
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode parent = null;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    public void add(TreeNode node) {
        if (node != null){
            if (this.value > node.value){
                if(this.left == null) {
                    this.left = node;
                    node.parent = this;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null){
                    this.right = node;
                    node.parent = this;
                } else {
                    this.right.add(node);
                }
            }
        }
    }

    public void inorder(){
        if (this.left != null){
            this.left.inorder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.inorder();
        }
    }

    public TreeNode search(int value){
        if(this.value == value){
            return this;
        }
        if (this.value > value && this.left != null){
            return this.left.search(value);
        }
        if (this.value < value && this.right != null){
            return this.right.search(value);
        }
        return null;
    }


    public void del(int value){
        TreeNode target = search(value);
        if (target == null){
            System.out.println("No such node");
            return;
        }
        if (target.parent == null){
            System.out.println("Can not delete the root node");
            return;
        }

        // leaf node
        if (target.left == null && target.right == null) {
            if (target.parent.left != null && target.parent.left.value == target.value) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
            return;
        }

        // two children
        if (target.left != null && target.right != null){
            TreeNode temp = target.right;
            while (temp.left != null){
                temp = temp.left;
            }
            target.value = temp.value;
            if (temp.parent.left != null && temp.parent.left.value == temp.value) {
                temp.parent.left = null;
            } else {
                temp.parent.right = null;
            }
            return;
        }


        // only one child
        if (target.right == null){
            if (target.parent.left != null && target.parent.left.value == target.value) {
                target.parent.left = target.left;
            } else {
                target.parent.right = target.left;
            }
        } else {
            if (target.parent.left != null && target.parent.left.value == target.value) {
                target.parent.left = target.right;
            } else {
                target.parent.right = target.right;
            }
        }
    }
}