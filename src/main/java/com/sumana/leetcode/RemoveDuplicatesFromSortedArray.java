package com.sumana.leetcode;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        /*
        0 1 1 2 2
        0 1 1 2 2
        0 1 2 2 2 k=1
        0 1 2 2 2 k=2
         */


        System.out.println(removeDuplicates(arr));

        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i]+"");
        }

        System.out.println(sj.toString());
        for (int i = 0; i < arr.length; i++) {}
    }
}
