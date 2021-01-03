package com.dataStructure.stack;

import java.util.Arrays;
import java.util.List;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String expression = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        String[] strArr = expression.split(" ");
        List<String> list = Arrays.asList(strArr.clone());
        System.out.println(reversePolish(list));
    }

    public static List<String> reversePolish(List<String> list) {
        Calculate cal = new Calculate();
        for (String str:list) {
            if(cal.isNumber(str)){
                cal.num.add(str);
                continue;
            }
            if(cal.isOperator(str)){
                if (cal.ope.isEmpty() || "(".equals(str) || cal.priority(str) > cal.priority(cal.ope.peek())) {
                    cal.ope.add(str);
                    continue;
                }
                if(")".equals(str)){
                    while(true){
                        String pop = cal.ope.pop();
                        if ("(".equals(pop)){
                            break;
                        }
                        cal.num.push(pop);
                    }
                    continue;
                }
                if(cal.priority(str) <= cal.priority(cal.ope.peek())) {
                    String pop = cal.ope.pop();
                    cal.num.push(pop);
                    cal.ope.add(str);
                    continue;
                }
            }
        }
        while(cal.ope.size() > 0){
            cal.num.add(cal.ope.pop());
        }
        int length = cal.num.size();
        String[] output = new String[length];
        for (int i = 0; i < length; i++) {
            output[length -1 - i] = cal.num.pop();
        }
        return Arrays.asList(output.clone());
    }
}
