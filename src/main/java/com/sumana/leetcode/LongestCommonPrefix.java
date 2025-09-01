package com.sumana.leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        while (!prefix.isEmpty()) {
            int prefixCount = 0;
            for (String str : strs) {
                if (str.startsWith(prefix)) {
                    prefixCount++;
                }
            }

            if (prefixCount < strs.length) {
                prefix = prefix.substring(0, prefix.length() - 1);
            } else  {
                break;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dodog","dodoria","flamingo"}));
    }
}
