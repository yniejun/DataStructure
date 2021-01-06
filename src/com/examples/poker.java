package com.examples;

import java.util.ArrayList;
import java.util.Collections;

public class poker {
    String[] variety = {"heart ♥", "clubs ♣", "spade ♠", "diamond ♦"};
    String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
    ArrayList<String> cards = new ArrayList<>();

    public poker() {
        cards.add("King");
        cards.add("Queen");
        for (String var : variety) {
            for (String num : number) {
                cards.add(var + num);
            }
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    public ArrayList<String>[] dealCard(int people) {
        ArrayList<String>[] lists = new ArrayList[people + 1];
        for (int i = 0; i < people + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < people; j++) {
                if (i >= cards.size() - 3) {
                    lists[people].add(cards.get(i));
                    break;
                } else if (i % people == j) {
                    lists[j].add(cards.get(i));
                    break;
                }
            }
        }
        return lists;
    }
}
