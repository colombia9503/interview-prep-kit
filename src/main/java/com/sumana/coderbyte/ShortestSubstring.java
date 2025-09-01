package com.sumana.coderbyte;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortestSubstring {
    public static String MinWindowSubstring(String[] strArr) {
        // code goes here
        String N = strArr[0];
        String K = strArr[1];

        Map<Character, Integer> kChMap = getCharacterCountMap(K);

        int[] idx = new int[]{0, 0};
        int[] minWindowIdx = new int[]{0, 0};

        while (idx[1] < N.length()) {
            if (!isValidWindow(N.substring(idx[0], idx[1]), kChMap)) {
                ++idx[1];
            } else {
                minWindowIdx[0] = idx[0];
                minWindowIdx[1] = idx[1];
                ++idx[0];
            }
        }

        return N.substring(minWindowIdx[0], minWindowIdx[1]);
    }

    private static boolean isValidWindow(String subStr, Map<Character, Integer> kCharMap) {
        Map<Character, Integer> subStrChMap = getCharacterCountMap(subStr, kCharMap);

        boolean isValid = true;

        for (Map.Entry<Character, Integer> entry : subStrChMap.entrySet()) {
            if (!(kCharMap.get(entry.getKey()) <= entry.getValue())) {
                isValid = false;
            }
        }

        return isValid && subStrChMap.size() == kCharMap.size();
    }

    private static Map<Character, Integer> getCharacterCountMap(String str) {
        Map<Character, Integer> chMap = new HashMap<>();

        for (Character ch : str.toCharArray()) {
            chMap.merge(ch, 1, Integer::sum);
        }

        return chMap;
    }

    private static Map<Character, Integer> getCharacterCountMap(String str, Map<Character, Integer> kChMap) {
        Map<Character, Integer> chMap = new HashMap<>();

        for (Character ch : str.toCharArray()) {
            if (kChMap.containsKey(ch)) {
                chMap.merge(ch, 1, Integer::sum);
            }
        }

        return chMap;
    }

    public static void main(String[] args) {
        System.out.println(MinWindowSubstring(new String[]{"ahffaksfajeeubsne", "jefaa"}));
    }
}
