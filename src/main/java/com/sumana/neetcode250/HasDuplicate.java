package com.sumana.neetcode250;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<>();

        for (int num : nums) {
            if (!result.add(num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1,2,3,4,5}));
        System.out.println(hasDuplicate(new int[]{1,2,3,4,5,5}));
    }
}
