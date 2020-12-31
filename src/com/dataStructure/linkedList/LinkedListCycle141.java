package com.dataStructure.linkedList;

import java.util.HashMap;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        // create ListNode
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node1;
//        node3.next = node4;
//        node4.next = node2;
        Solution141 solution = new Solution141();
        System.out.println(solution.hasCycle(node1));
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode temp = head;
        while(head.next != null && temp.next != null &&temp.next.next != null) {
            if (head.next == temp.next.next){
                return true;
            }
            head = head.next;
            temp = temp.next.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        int length = 1;
        while(head.next != null){
            ListNode temp = head;
            for (int i = 0; i < length - 1; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) {
                return false;
            }
            if (temp.next == head) {
                return true;
            }
            head = head.next;
            length++;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode temp = head.next;
        HashMap<Integer, ListNode> hash = new HashMap<>();
        while(true){
            if(temp.next == null) {
                return false;
            }
            if(hash.get(temp.val) == temp){
                return true;
            }
            hash.put(temp.val, temp);
            temp = temp.next;
        }
    }
}