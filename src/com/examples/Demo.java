package com.examples;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        poker p = new poker();
        p.shuffleCards();
        int number = 3;
        ArrayList<String>[] card = p.dealCard(number);
        for (int i = 0; i < number; i++) {
            System.out.println("Member" + i + ":");
            for (String str : card[i]) {
                System.out.println(str);
            }
            System.out.println("");
        }
        System.out.println("unreleased card \n" + card[number]);

    }
}

