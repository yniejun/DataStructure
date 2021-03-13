package com.solutions;

import java.util.Arrays;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int interval = (numRows - 1) * 2;
        int len = s.length();
        char[] ans = new char[len];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            int front = i;
            int back = interval - i;
            while (front < len || back < len) {
                if (i == 0 || i == numRows - 1) {
                    back = len;
                }
                if (front < len && index < len) {
                    ans[index++] = s.charAt(front);
                    front = front + interval;
                }
                if (back < len && index < len) {
                    ans[index++] = s.charAt(back);
                    back = back + interval;
                }

            }
        }
        return new String(ans);
    }
}
