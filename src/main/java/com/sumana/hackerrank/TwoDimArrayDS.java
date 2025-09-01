package com.sumana.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TwoDimArrayDS {

    // Completed..
    // 1. calculate the hourglass quantity (n-2)^2 when n%3 = 0 if not (n-1)^2
    // get all the hourglasses
    // sum and store all hourglasses result
    // get the highest hourglass sum and print it

    public static int getHourglassSum(List<List<Integer>> arr) {
        //final var hourglassQty = arr.size() % 3 == 0 ? (arr.size()-2)^2 : (arr.size()-1)^2;
        List<Integer> results = new ArrayList<>();

        for(var i=0; i + 2<arr.size(); i++) {
            for(var j=0; j + 2<arr.size(); j++) {
                results.add(sumHourGlassWithIdx(i, j, arr));
            }
        }

        return results.stream().max(Integer::compareTo).orElse(0);
    }

    private static int sumHourGlassWithIdx(int i, int j, List<List<Integer>> arr) {
        int result = 0;

        for(var counti = 0; counti < 3; counti++) {
            for(var countj = 0; countj < 3; countj++) {
                if (!(counti == 1 && (countj == 0 || countj == 2))) {
                    result += arr.get(i + counti).get(j + countj);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
