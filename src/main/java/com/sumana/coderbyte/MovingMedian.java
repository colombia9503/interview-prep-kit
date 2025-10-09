package com.sumana.coderbyte;

import java.util.StringJoiner;

//bad excersice
public class MovingMedian {
    public static String movingMedian(int[] arr) {
        StringJoiner result = new StringJoiner(",");
        int windowSize = arr[0];

        int right = 1;
        int left = 1;

        while (right < arr.length) {
            int currentSize = right - left + 1;

            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            float div = (float) sum / currentSize;

            div = div < 1 ? 0 : div;

            result.add(Math.round(div) + "");
            if (currentSize == windowSize) {
                right++;
                left++;
            } else if (currentSize < windowSize) {
                right++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(movingMedian(new int[] {5, 2, 4, 6}));
        System.out.println(movingMedian(new int[] {3, 0, 0, -2, 0, 2, 0, -2}));
        System.out.println(movingMedian(new int[] {3, 1, 3, 5, 10, 6, 4, 3, 1}));
    }
}
