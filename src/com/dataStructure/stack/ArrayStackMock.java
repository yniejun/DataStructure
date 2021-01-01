package com.dataStructure.stack;

import java.util.Scanner;

public class ArrayStackMock {
    public static void main(String[] args) {
        ArrayStack test = new ArrayStack(5);
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

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    //full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public void list() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

