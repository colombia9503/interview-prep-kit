package com.sumana.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanInt {

    public static int romanToInt(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        
        var previous = ' ';
        var sum = 0;
        for (int i = 0; i < s.length(); i++) {
            var previousAmount = charMap.getOrDefault(previous, 0);
            var currentRomanInt = s.charAt(i);
            var currentAmount = charMap.getOrDefault(s.charAt(i), 0);

            if (currentAmount % 5 == 0 && previousAmount < currentAmount) {
                sum -= previousAmount * 2;
            }

            sum += currentAmount;
            previous = currentRomanInt;
        }

        return sum;
    }

    public static int romanToIntShorter(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        var sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = charMap.get(s.charAt(i));
            int next = i + 1 < s.length() ? charMap.get(s.charAt(i + 1)) : 0;

            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
