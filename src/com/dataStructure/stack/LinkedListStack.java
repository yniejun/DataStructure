package com.dataStructure.stack;

import com.dataStructure.linkedList.ListNode;

import java.util.Scanner;

public class LinkedListStack {
    public static void main(String[] args) {
        LLStack test = new LLStack();
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show; exit; push; pop");
            System.out.println("Input command");
            key = scanner.next();
            switch (key){
                case "show":
                    test.list();
                    break;
                case "exit" :
                    loop = false;
                    break;
                case "push" :
                    System.out.println("Input value");
                    int pushVal = scanner.nextInt();
                    test.push(pushVal);
                    break;
                case "pop":
                    try{
                        int res = test.pop();
                        System.out.println(res);
                    } catch(Exception e) {
                        System.out.println("Stack is empty");
                    }
                default:
                    break;
            }
        }

    }
}

class LLStack {
    private ListNode head = new ListNode(0, null);

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int value) {
        ListNode temp = new ListNode(value);
        if (head.next != null) {
            temp.next = head.next;

        }
        head.next = temp;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        int res = head.next.val;
        head.next = head.next.next;
        return res;
    }

    public void list() {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.val);
            temp = temp.next;
        }
    }
}
