package com.dataStructure.Tree.binarySortTree;

class SumofLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

class Solution{
    private int sum;
    private LeetTreeNode parent;

    public int sumOfLeftLeaves(LeetTreeNode root) {
        if (root.left != null) {
            parent = root;
            return sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            parent = root;
            return sumOfLeftLeaves(root.right);
        }
        if (parent.left == root) {
            sum += root.val;
        }
        return sum;
    }

}


class LeetTreeNode {
    int val;
    LeetTreeNode left;
    LeetTreeNode right;

    LeetTreeNode() {
    }

    LeetTreeNode(int val) {
        this.val = val;
    }

    LeetTreeNode(int val, LeetTreeNode left, LeetTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

