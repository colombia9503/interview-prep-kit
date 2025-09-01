package com.sumana.leetcode;

public class PalindromeNumber {

    // converting to string my solution, not optimal
    public static boolean isPalindrome(int x) {
        var xArr = String.valueOf(x).split("");
        var halfDigits = xArr.length % 2 == 0 ? xArr.length / 2 : (xArr.length - 1) / 2;

        var i = 0;
        var j = xArr.length - 1;
        while (i < halfDigits) {
            if (!xArr[i].equals(xArr[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean isPalindromeOptimalSolution(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            var lastDigit = x % 10;

            reversed = (reversed * 10) + lastDigit;

            x /= 10;
        }

        return reversed == original;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome(21521));
    }
}
