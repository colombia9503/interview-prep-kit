package com.sumana.coderbyte;

public class RunLength {

    public static String runLength(String str) {
        if (str.isBlank()) {
            return "";
        }

        char currCh = str.charAt(0);
        int i = 1;
        while (i < str.length() && currCh == str.charAt(i)) {
            i++;
        }

        return i + String.valueOf(currCh) + runLength(str.substring(i));
    }

    public static void main(String[] args) {
        System.out.println(runLength("aaaabbbccdewwwwwww"));
    }
}
