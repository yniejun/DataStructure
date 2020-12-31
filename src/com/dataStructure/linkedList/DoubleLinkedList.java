package com.dataStructure.linkedList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        // create HeroNode
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "firstHero", "NO1");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "secondHero", "NO2");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "thirdHero", "NO3");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "fourthHero", "NO4");

        // create list
        CDoubleLinkedList doubleList = new CDoubleLinkedList();
        doubleList.addByOrder(hero2);
        doubleList.addByOrder(hero3);
        doubleList.addByOrder(hero1);
        doubleList.addByOrder(hero4);
        doubleList.show();

        // edit
        doubleList.edit(new DoubleHeroNode(4,"fourthHero","No.4"));
        doubleList.show();

        // delete
        doubleList.deleteByID(4);
        doubleList.show();

    }
}

// defined doubleLinkedList to manage hero data
class CDoubleLinkedList {
    // initialize head node
    private final DoubleHeroNode head = new DoubleHeroNode(0, "1", "1");

    public DoubleHeroNode getHead() {
        return head;
    }

    // find the end of the linkedList
    // next point towards new
    public void add(DoubleHeroNode hero) {
        DoubleHeroNode temp = head;
        // traverse
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = hero;
        hero.previous = temp;
    }

    public void addByOrder(DoubleHeroNode hero) {
        DoubleHeroNode temp = head;
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
            hero.previous = temp;
        }
    }

    public void deleteByID(int id) {
        DoubleHeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("This hero is not existed");
                break;
            }
            if (temp.id == id) {
                // find the node
                if (temp.next != null) temp.next.previous = temp.previous;
                if (temp.previous != null ) temp.previous.next = temp.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * edit Name and NickName
     */
    public void edit(DoubleHeroNode hero) {
        DoubleHeroNode temp = head;
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
        DoubleHeroNode temp = head;
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
        DoubleHeroNode temp = head;
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
class DoubleHeroNode {
    public int id;
    public String name;
    public String nickName;
    public DoubleHeroNode next;
    public DoubleHeroNode previous;

    // constructor
    public DoubleHeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode [id: " + id + " name: " + name + " nickName: " + nickName + "]";
    }
}