package com.sumana.coderbyte;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static long fibonacci(long n, Map<Long, Long> memoizationMap) {
        if (memoizationMap.containsKey(n)) {
            return memoizationMap.get(n);
        }

        if (n == 1 ||  n == 2) {
            return 1;
        }

        memoizationMap.put(n, fibonacci(n - 1, memoizationMap) + fibonacci(n - 2, memoizationMap));
        return memoizationMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10, new HashMap<>()));
    }
}
