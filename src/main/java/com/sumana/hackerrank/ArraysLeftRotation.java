package com.sumana.hackerrank;

import java.util.*;

public class ArraysLeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        Stack<Integer> aux = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (var i = d-1; i >= 0 ; i--) {
            aux.add(a.get(i));
        }

        for (var i = d; i < a.size(); i++) {
            result.add(a.get(i));
        }

        while (!aux.isEmpty()) {
            result.add(aux.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51));

        System.out.println(rotLeft(a, 10));
    }
}
