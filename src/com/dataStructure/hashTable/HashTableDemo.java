package com.dataStructure.hashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String args[]) {
        String key = "";
        Scanner scan = new Scanner(System.in);
        boolean Flag = true;
        HashTable hash = new HashTable(5);
        while (Flag) {
            System.out.println("add; list");
            System.out.println("Input command");
            key = scan.next();
            switch (key) {
                case "add":
                    System.out.println("Please input id");
                    int id = Integer.parseInt(scan.next());
                    System.out.println("Please input name");
                    String name = scan.next();
                    Employee newEmp = new Employee(id, name);
                    hash.add(newEmp);
                    break;
                case "list":
                    hash.list();
                    break;
                case "exit":
                    scan.close();
                    Flag = false;
                    break;
                default:
                    break;
            }
        }

    }
}

class HashTable {
    private EmpLinkedList[] empLinkedListArr;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    private int modHash(int id) {
        return id % size;
    }

    public void add(Employee newEmp) {
        EmpLinkedList empLinkedList = empLinkedListArr[modHash(newEmp.id)];
        empLinkedList.add(newEmp);
    }

    public void list() {
        for (EmpLinkedList empLinkedList :
                empLinkedListArr) {
            empLinkedList.list();
        }
    }
}

class Employee {
    public int id;
    public String name;
    public Employee nextNode;

    public Employee(int id, String name) {
        this.id = id - 1;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}

class EmpLinkedList {
    public Employee firstEmp;

    public void add(Employee newEmp) {
        if (firstEmp == null) {
            firstEmp = newEmp;
            return;
        }
        Employee lastEmp = firstEmp;
        while (true) {
            if (lastEmp.nextNode == null) {
                lastEmp.nextNode = newEmp;
                break;
            }
            lastEmp = lastEmp.nextNode;
        }
    }

    public void list() {
        if (firstEmp == null) {
            System.out.println("List : Empty list");
            return;
        }
        Employee lastEmp = firstEmp;
        System.out.println("List : ");
        while (true) {
            if (lastEmp.nextNode == null) {
                System.out.println(lastEmp + "\n");
                return;
            }
            System.out.println(lastEmp);
            lastEmp = lastEmp.nextNode;
        }
    }

    public void delete(int id) {

    }

    public void search(int id){

    }


}
