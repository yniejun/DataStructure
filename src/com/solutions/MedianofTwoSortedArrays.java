package com.solutions;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,6,9}, new int[]{3,5,6,11}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] ans = new int[len];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                ans[index] = nums1[index1];
                index1++;
            } else {
                ans[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        if (index1 != m - 1 || (index1 == 0)) {
            for (int i = index1; i < m; i++) {
                ans[index++] = nums1[i];
            }
        }
        if (index2 != n - 1 || (index2 == 0)) {
            for (int i = index2; i < n; i++) {
                ans[index++] = nums2[i];
            }
        }
        int medium = len / 2;
        if (len % 2 == 0) {
            return (double) (ans[medium - 1] + ans[medium]) / 2;
        } else {
            return ans[medium];
        }
    }
}
