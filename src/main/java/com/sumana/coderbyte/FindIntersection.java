package com.sumana.coderbyte;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;

public class FindIntersection {

    public static String findIntersection(String[] strArr) {
        StringJoiner result = new StringJoiner(",");
        result.setEmptyValue("false");

        String[] s1 = strArr[0].split(", ");
        String[] s2 = strArr[1].split(", ");

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            map.put(s1[i], i);
        }

        for (String ch : s2) {
            if (map.containsKey(ch)) {
                result.add(String.valueOf(ch));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(findIntersection(new String[]{"a", "b"}));
    }
}
