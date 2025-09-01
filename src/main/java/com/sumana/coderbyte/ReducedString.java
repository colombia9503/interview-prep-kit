package com.sumana.coderbyte;

import java.util.Map;

public class ReducedString {
    public static String stringReduction(String str) {
        // code goes here
        Map<String, String> combinations = Map.of(
                "bc", "a", "ac", "b", "ab", "c", "cb", "a", "ca", "b", "ba", "c"
        );

        StringBuilder res = new StringBuilder(str);
        int i = 0;

        while (i < res.length() - 1) {
            String replacement = combinations.get(res.substring(i, i + 2));
            if (replacement != null) {
                res.replace(i, i + 2, replacement);
                i = 0;
            } else {
                i++;
            }
        }

        return "" + res.toString().length();
    }

    public static void main(String[] args) {
        System.out.println(stringReduction("bcab"));
        // aab
    }
}
