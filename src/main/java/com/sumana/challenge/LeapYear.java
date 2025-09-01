package com.sumana.challenge;

public class LeapYear {

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return year % 100 != 0 || year % 400 == 0;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(1928));
        System.out.println(isLeapYear(1977));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2002));
        System.out.println(isLeapYear(2004));
    }
}
