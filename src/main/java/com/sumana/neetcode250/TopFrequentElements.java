package com.sumana.neetcode250;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return frequencyMap.entrySet()
                .stream()
                .sorted(
                        (e1, e2) -> e2.getValue().compareTo(e1.getValue())
                )
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        topKFrequent(
                                new int[]{1, 2, 2, 3, 3, 3},
                                2
                        )
                )
        );
    }
}
