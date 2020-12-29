package com.dataStructure.linkedList;

public class SingleLinkedListWithoutHead {
    public static void main(String[] args) {
        // create list
        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // create list
        ListNode n3 = new ListNode(4, null);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(1, n2);

        Solution s = new Solution();
        show(s.mergeTwoLists(node1,n1));

    }
    public static void show(ListNode l){
        while(l != null){
            System.out.println(l);
            l = l.next;
        }
    }
}

class Solution {
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

/**
 * Definition for singly-linked list. * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        return "ListNode [val: " + val + "]";
    }

}