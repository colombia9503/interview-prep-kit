package com.sumana.neetcode250;

import java.util.Arrays;

public class ConcatenationOfArrays {
    public static int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i + nums.length] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 3})));
    }
}
