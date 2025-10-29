package com.sumana.neetcode250;

import java.util.Arrays;

public class SortColors {
    // brute force implementation
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    var aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{1,0,1,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
