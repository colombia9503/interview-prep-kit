package com.sumana.coderbyte;

public class LongestPalindrome {
    public static String palindromicSubstringUnOptimized(String str) {
        String longestPalindrome = "--";
        String currentStr = "";
        String currentStrRev = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                currentStr = str.substring(i, j);
                currentStrRev = new StringBuilder(currentStr).reverse().toString();

                if (currentStr.equals(currentStrRev)) {
                    if (currentStr.length() > longestPalindrome.length()) {
                        longestPalindrome = currentStr;
                    }
                }
            }
        }

        return !longestPalindrome.equals("--") ? longestPalindrome : "none";
    }
}
