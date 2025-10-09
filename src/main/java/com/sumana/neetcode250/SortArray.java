package com.sumana.neetcode250;

import java.util.Arrays;

public class SortArray {
    public static int[] sortArray(int[] nums) {
        return mergeSortHelper(nums, 0, nums.length - 1);
    }

    public static int[] mergeSortHelper(int[] nums, int l, int r) {
        if (l == r) {
            return nums;
        }

        int m = (l + r) / 2;

        mergeSortHelper(nums, l, m);
        mergeSortHelper(nums, m + 1, r);
        merge(nums, r, m, l);

        return nums;
    }

    private static void merge(int[] nums, int r, int m, int l) {
        int[] left = Arrays.copyOfRange(nums, l, m+1);
        int[] right = Arrays.copyOfRange(nums, m+1, r+1);
        int i = l, j = 0, k = 0;

        while (j < left.length && k < right.length) {
            if (left[j] <= right[k]) {
                nums[i] = left[j];
                j++;
            } else {
                nums[i] = right[k];
                k++;
            }
            i++;
        }

        while (j < left.length) {
            nums[i] = left[j];
            j++;
            i++;
        }

        while (k < right.length) {
            nums[i] = right[k];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{7, 15, 3, 5, 32, 1, 2, 4, 6, 8})));
    }
}
