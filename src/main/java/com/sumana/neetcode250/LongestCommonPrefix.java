package com.sumana.neetcode250;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String shortestPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestPrefix.length()) {
                shortestPrefix = strs[i];
            }
        }

        while (!shortestPrefix.isEmpty()) {
            int count = 0;
            for (String str : strs) {
                if (str.startsWith(shortestPrefix)) {
                    count++;
                }
            }

            if (count == strs.length) {
                break;
            } else {
                shortestPrefix = shortestPrefix.substring(0, shortestPrefix.length() - 1);
            }
        }

        return shortestPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog", "dababado", "dedo"}));
        System.out.println(longestCommonPrefix(new String[]{"deg", "debabado", "dedo"}));
    }
}
