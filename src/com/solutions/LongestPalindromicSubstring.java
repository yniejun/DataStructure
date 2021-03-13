package com.solutions;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        String ans = s.substring(0, 1);
        int len = s.length();
        int longest = 0;
        int max_longest = 0;
        for (int i = 0; i < len - 1; i++) {
            int start = i;
            int end = i;
            while (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                end = i + 1;
                longest = end - start;
                if (longest > max_longest) {
                    max_longest = longest;
                    ans = s.substring(start, end + 1);
                }
                i++;
            }
            while (start - 1 >= 0 && end + 1 <= len - 1) {
                if (s.charAt(start - 1) != s.charAt(end + 1)) {
                    break;
                }
                start--;
                end++;
                longest = end - start;
                if (longest > max_longest) {
                    max_longest = longest;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }
}
