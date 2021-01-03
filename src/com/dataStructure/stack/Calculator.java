package com.dataStructure.stack;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Calculate cal = new Calculate();
        String key = "";
        int num1;
        int num2;
        int num3;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Input the expression:");
            key = scanner.next();
            if (key.equals("e")) {
                loop = false;
                break;
            }
            char[] chArr = key.toCharArray();
            for (char chCurrent : chArr) {
                Boolean needCal = false;
                if (cal.isOperator(chCurrent)) {
                    if (cal.operator.empty()) {
                        cal.operator.add(chCurrent);
                        continue;
                    }
                    char lastOpe = (char) cal.operator.peek();
                    if (cal.priority(lastOpe) >= cal.priority(chCurrent)) {
                        needCal = true;
                    } else {
                        cal.operator.add(chCurrent);
                    }
                } else if (cal.isNumber(chCurrent)) {
                    cal.number.add((int) chCurrent - 48);
                } else {
                    System.out.println("Wrong input");
                    break;
                }
                if (needCal) {
                    num1 = cal.number.pop();
                    num2 = cal.number.pop();
                    char ope = cal.operator.pop();
                    num3 = cal.calculate(num1, num2, ope);
                    cal.number.add(num3);
                    cal.operator.add(chCurrent);
                }
            }
            while(cal.number.size() != 1){
                num1 = cal.number.pop();
                num2 = cal.number.pop();
                char ope = cal.operator.pop();
                num3 = cal.calculate(num2, num1, ope);
                cal.number.add(num3);
            }
            System.out.println(cal.number.pop());
        }
    }
}

