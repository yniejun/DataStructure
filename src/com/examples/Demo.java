package com.examples;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        countChar();
//        poker p = new poker();
//        p.shuffleCards();
//        int number = 3;
//        ArrayList<String>[] card = p.dealCard(number);
//        for (int i = 0; i < number; i++) {
//            System.out.println("Member" + i + ":");
//            System.out.println(card[i]);
//            System.out.println("");
//        }
//        System.out.println("unreleased card \n" + card[number]);

    }


    public static void countChar() {
        System.out.println("Input string:");
        Map<Character, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            char[] key = scan.next().toCharArray();
            for (char c : key) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

        }
        for (Map.Entry<Character, Integer> entry :
                map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

