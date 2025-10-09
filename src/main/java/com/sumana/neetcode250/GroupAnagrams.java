package com.sumana.neetcode250;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {
            String sortedString = sortString(str);
            resultMap.putIfAbsent(sortedString, new ArrayList<>());
            resultMap.get(sortedString).add(str);
        }

        return new ArrayList<>(resultMap.values());
    }

    private static String sortString(String str) {
        char[] chArr = str.toCharArray();
        Arrays.sort(chArr);
        return String.valueOf(chArr);
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
