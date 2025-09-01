package com.sumana.hackerrank;

import java.util.List;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {;
        var minimunBribes = 0;

        for (var i=0; i < q.size(); i++) {
            if (q.get(i) - (i+1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j=i+1; j < q.size(); j++) {
                if (q.get(i) > q.get(j)) {
                    minimunBribes++;
                }
            }
        }

        System.out.println(minimunBribes);
    }

    public static void main(String[] args) {
        minimumBribes(List.of(1, 2, 5, 3, 7, 8, 6, 4));
        // 1 2 3 4 5 6 7 8
        // 1 2 5 3 4 6 7 8 -> +2
        // 1 2 5 3 6 4 7 8 -> +1
        // 1 2 5 3 7 6 4 8 -> +2
        // 1 2 5 3 7 8 6 4 -> +2
        // Result = 7
    }
}
