package com.dataStructure;

import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:show e:exit a:add g:get");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showAll();
                    break;
                case 'a':
                    try {
                        System.out.println("Please input an integer");
                        int input = scanner.nextInt();
                        queue.addQueue(input);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                default:
                    loop = false;
                    break;
            }
        }
    }
}

//Class ArrayQueue
class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // constructor
    public ArrayQueue(int Max) {
        maxSize = Max;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    private boolean isFull() {
        return rear % maxSize == front && (rear != 0);
    }

    private boolean isEmpty() {
        boolean isempty = front == rear;
        if (isempty) {
            front = rear = 0;
        }
        return isempty;
    }

    public void addQueue(int a) {
        if (isFull()) {
            throw new RuntimeException("Full error");
        }
        arr[rear % maxSize] = a;
        rear++;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[(front++) % maxSize];
    }

    public void showAll() {
        for (int i = front; i <= front + ((rear - front - 1) % maxSize); i++) {
            System.out.print(arr[i % maxSize] + " ");
        }
    }
}
