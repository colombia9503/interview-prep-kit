package com.sumana.coderbyte;

import java.util.HashMap;
import java.util.Map;

public class StepWalking {
    public static long stepWalking(long num) {
        if (num == 1 || num == 2) {
            return num;
        }

        return stepWalking(num - 1) + stepWalking(num - 2);
    }

    public static long memoStepWalking(long num, Map<Long, Long> memoizationMap) {
        if (memoizationMap.containsKey(num)) {
            return memoizationMap.get(num);
        }

        if (num == 1 || num == 2) return num;

        memoizationMap.put(num, memoStepWalking(num - 1, memoizationMap) + memoStepWalking(num - 2, memoizationMap));
        return memoizationMap.get(num);
    }

    public static void main(String[] args) {
        System.out.println(memoStepWalking(1998, new HashMap<>()));
        //System.out.println(stepWalking(80));
    }
}
