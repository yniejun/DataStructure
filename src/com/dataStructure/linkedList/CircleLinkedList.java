package com.dataStructure.linkedList;

public class CircleLinkedList {
    public static void main(String[] args) {
        // create HeroNode
        CircleHeroNode hero1 = new CircleHeroNode(1);
        CircleHeroNode hero2 = new CircleHeroNode(2);
        CircleHeroNode hero3 = new CircleHeroNode(3);
        CircleHeroNode hero4 = new CircleHeroNode(4);
        CircleHeroNode hero5 = new CircleHeroNode(5);

        // create list
        CCircleLinkedList circleList = new CCircleLinkedList(hero1);
        circleList.add(hero2);
        circleList.add(hero3);
        circleList.add(hero4);
        circleList.add(hero5);
        circleList.show();

        josephus(hero1, 1, 2);
    }

    public static void josephus(CircleHeroNode hero, int k, int m) {
        if (hero == null) {
            return;
        }
        CircleHeroNode temp = hero;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        boolean flag = true;
        while (flag) {
            if (temp == temp.next) flag = false;
            for (int i = 0; i < m - 2; i++) {
                temp = temp.next;
            }
            System.out.println(temp.next);
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

}

// defined doubleLinkedList to manage hero data
class CCircleLinkedList {
    // initialize head node
    private CircleHeroNode first = null;

    public CCircleLinkedList(CircleHeroNode first) {
        this.first = first;
        first.next = first;
    }

    public CircleHeroNode getFirst() {
        return first;
    }

    // find the end of the linkedList
    // next point towards new
    public void add(CircleHeroNode hero) {
        CircleHeroNode temp = first;
        // traverse
        while (temp.next != first) {
            temp = temp.next;
        }
        temp.next = hero;
        hero.next = first;
    }


    public void deleteByID(int id) {
        CircleHeroNode temp = first;
        while (true) {
            if (temp.next.id == id) {
                // find the node
                temp.next = temp.next.next;
                break;
            }
            if (temp.next == first) {
                System.out.println("This hero is not existed");
                break;
            }
            temp = temp.next;
        }
    }


    public void show() {
        if (first.next == null) {
            System.out.println("Empty list");
            return;
        }
        CircleHeroNode temp = first;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != first);
        System.out.println("Circle End");
    }
}

// defined heroNode
class CircleHeroNode {
    public int id;
    public CircleHeroNode next;

    // constructor
    public CircleHeroNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CircleHeroNode [id: " + id + "]";
    }
}