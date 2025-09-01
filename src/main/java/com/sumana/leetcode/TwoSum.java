package com.sumana.leetcode;

import java.util.HashMap;

public class TwoSum {
    // brute force approach because it checks all the pairs until finds anything.
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // one pass hashmap lookup
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var compliment = target - nums[i];
            if (indexHashMap.containsKey(compliment)) {
                return new int[]{indexHashMap.get(compliment), i};
            }

            indexHashMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

    }
}
