package com.dataStructure.linkedList;

import java.util.Stack;

public class SingleLinkedListWithoutHead {
    public static void main(String[] args) {
        // create list
        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // create list
        ListNode n3 = new ListNode(4, null);
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);

        Solution s = new Solution();
//        show(s.mergeTwoLists(node1,n1));
//        System.out.println(s.isPalindrome(n1));
        show(s.removeNthFromEnd(n1, 2));

    }
    public static void show(ListNode l){
        while(l != null){
            System.out.println(l);
            l = l.next;
        }
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }
        while(true){
            if (head.val != stack.pop()){
                return false;
            }
            if (head.next == null) {
                return true;
            }
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n != 1)){
            return head;
        }
        if(head.next == null){
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode currentInverse = newHead;
        int count = 0;
        while (true) {
            if (head.next == null) {
                currentInverse.next = currentInverse.next.next;
                return newHead.next;
            }
            if (count == n - 1) {
                head = head.next;
                currentInverse = currentInverse.next;
            } else {
                head = head.next;
                count++;
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode newHead = new ListNode();
        ListNode newHeadVir = newHead;
        while (true) {
            if (head1.val <= head2.val) {
                newHeadVir.next = head1;
                newHeadVir = newHeadVir.next;
                if (head1.next == null) {
                    head1.next = head2;
                    return newHead.next;
                }
                head1 = head1.next;
            } else {
                newHeadVir.next = head2;
                newHeadVir = newHeadVir.next;
                if (head2.next == null) {
                    head2.next = head1;
                    return newHead.next;
                }
                head2 = head2.next;
            }
        }
    }
}

