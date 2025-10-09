package com.sumana.neetcode250;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int current = map.getOrDefault(num, 0) + 1;
            map.put(num, current);
            if (current > nums.length / 2) {
                return num;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
