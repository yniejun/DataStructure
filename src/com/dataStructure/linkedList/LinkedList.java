package com.dataStructure.linkedList;

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {
        // create HeroNode
        HeroNode hero1 = new HeroNode(1, "firstHero", "NO1");
        HeroNode hero2 = new HeroNode(2, "secondHero", "NO2");
        HeroNode hero3 = new HeroNode(3, "thirdHero", "NO3");
        HeroNode hero4 = new HeroNode(4, "fourthHero", "NO4");

        // create list
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(hero1);
        list.addByOrder(hero3);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.show();

        // edit
        list.edit(new HeroNode(4, "4hero", "No.4"));
        list.show();

        // select
//        list.selectById(3);

        // delete
//        list.deleteByID(3);
//        list.show();
//        list.deleteByID(2);
//        list.show();
//        list.deleteByID(1);
//        list.show();
//        list.deleteByID(4);
//        list.show();
//        list.deleteByID(1);
//        list.show();
        inverseList(list.getHead());
        list.show();



//        reversePrint(list.getHead());


    }
    // select the n-k node
    public static HeroNode findInverseK(SingleLinkedList list, int K){
        HeroNode head = list.getHead();
        HeroNode current = head.next;
        HeroNode currentInverseK = current;
        int count = 0;
        while(true){
            if (current.next == null) {
                return currentInverseK;
            }
            if (count == K - 1) {
                current = current.next;
                currentInverseK = currentInverseK.next;
            } else {
                current = current.next;
                count++;
            }
        }
    }
     public static void inverseList(HeroNode head){
         HeroNode first = head.next;
         while(true){
             if (first.next == null){
                 return;
             }
             HeroNode currentFirst = first.next;
             first.next = currentFirst.next;
             currentFirst.next = head.next;
             head.next = currentFirst;
         }
     }

    public static void inverseList(HeroNode head, int m, int n){
        HeroNode beforeHead = new HeroNode(0,"","");
        beforeHead.next = head;
        HeroNode virtualHead = beforeHead;
        for (int i = 1; i < m ; i++) {
            virtualHead = virtualHead.next;
        }
        HeroNode first = virtualHead.next;
        int count = m;
        while(true){
            if (count >= n || virtualHead.next == null){
                return;
            }
            HeroNode currentFirst = first.next;
            first.next = currentFirst.next ;
            currentFirst.next = virtualHead.next;
            virtualHead.next = currentFirst;
            count++;
        }
    }

     public static void inverseListWithoutHead(HeroNode head){
        HeroNode temporaryHead = new HeroNode(0, "", "");
        HeroNode first = head;
        HeroNode next = null;
        while(true){
            if (head.next == null){
                break;
            }
            next = first.next;
            first.next = temporaryHead.next;
            temporaryHead.next = first;
            first = next;
        }
    }

    public static void reversePrint(HeroNode head){
        if (head == null) {
            System.out.println("Empty list");
        }
        Stack heroStack = new Stack();
        while (true) {
            if (head.next == null) {
                break;
            }
            heroStack.add(head.next);
            head = head.next;
        }
        while (heroStack.size() > 0) {
            System.out.println(heroStack.pop());
        }
    }
}

// defined singleLinkedList to manage hero data
class SingleLinkedList {
    // initialize head node
    private final HeroNode head = new HeroNode(0, "1", "1");

    public HeroNode getHead(){
        return head;
    }
    // find the end of the linkedlist
    // next point towards new
    public void add(HeroNode hero) {
        HeroNode temp = head;
        // traverse
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = hero;
    }

    public void addByOrder(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = hero;
                break;
            }
            if (temp.next.id > hero.id) {
                hero.next = temp.next;
                temp.next = hero;
                break;
            } else if (temp.next.id == hero.id) {
                // if the added node is existed, will fail to add.
                System.out.printf("The id = %d is existed\n\n", hero.id);
                ;
                break;
            }
            temp = temp.next;
        }
    }

    public void deleteByID(int id) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("This hero is not existed");
                break;
            }
            if (temp.next.id == id) {
                // find the node
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * edit Name and NickName
     */
    public void edit(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("This hero is not existed");
                break;
            }
            if (temp.next.id == hero.id) {
                // find the node
                temp.next.name = hero.name;
                temp.next.nickName = hero.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    public void selectById(int id) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("This hero is not existed\n");
                break;
            }
            if (temp.next.id == id) {
                // find the node
                System.out.println(temp.next + "\n");
                break;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("Empty list");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("");
                return;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}


// defined heroNode
class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;

    //constructor
    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [id: " + id + " name: " + name + " nickName: " + nickName + "]";
    }
}