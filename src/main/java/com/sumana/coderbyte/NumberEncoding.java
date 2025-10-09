package com.sumana.coderbyte;

public class NumberEncoding {

    public static String NumberEncoding(String str) {
        StringBuilder result = new StringBuilder();

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (Character.isAlphabetic(ch)) {
                result.append(ch - 96);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(NumberEncoding("jaj-a"));
    }
}
