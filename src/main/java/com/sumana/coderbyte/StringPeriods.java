package com.sumana.coderbyte;

public class StringPeriods {
    public static String stringPeriods(String str) {
        return String.valueOf(stringPeriodsHelper(str, (int) Math.ceil((double) str.length()/2)));
    }

    public static String stringPeriodsHelper(String str, int idx) {
        if (idx == 0 || str.length() <= 1) {
            return "-1";
        }

        String currentSegment = str.substring(0, idx);
        StringBuilder currentString = new StringBuilder(currentSegment);
        while (currentString.length() < str.length() && !str.contentEquals(currentString)) {
            currentString.append(currentSegment);
        }

        if (currentString.toString().equals(str)) {
            return currentSegment;
        } else {
            return stringPeriodsHelper(str, --idx);
        }
    }

    public static void main(String[] args) {
        System.out.println(stringPeriods("abababababababababab")); //
    }
}
