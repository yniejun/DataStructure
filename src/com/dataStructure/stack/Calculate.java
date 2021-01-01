package com.dataStructure.stack;

import java.util.Stack;

public class Calculate {
    public Stack<Integer> num = new Stack<>();
    public Stack<Character> operator = new Stack<>();

    public boolean isOperator(char operator) {
        return operator == '/' || operator == '*' || operator == '+' || operator == '-';
    }

    public boolean isNumber(char num) {
        return String.valueOf(num).matches("^[0-9]*$");
    }

    public int priority(char operator) {
        switch (operator) {
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 1;
    }

    public int calculate(int n1, int n2, char operation) {
        switch (operation) {
            case '/':
                return n1 / n2;
            case '*':
                return n1 * n2;
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
        }
        return -1;
    }
}
