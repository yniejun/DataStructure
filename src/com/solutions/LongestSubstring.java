package com.solutions;

import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int max_count = 0;
        int count;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) >= start) {
                count = i - start;
                max_count = Math.max(max_count, count);
                start = map.get(arr[i]) + 1;
            }
            map.put(arr[i], i);
        }
        if (start != arr.length - 1) {
            count = arr.length - start;
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}
