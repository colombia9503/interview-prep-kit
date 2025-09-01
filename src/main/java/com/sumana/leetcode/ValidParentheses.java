package com.sumana.leetcode;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidSlowExec(String s) {

        if (s.length() % 2 != 0 || !"([{".contains(String.valueOf(s.charAt(0)))) return false;

        int parenthesisCount = 0;

        Map<Character, Character> closeParenthesisMap = Map.of(
                '(', ')', '[', ']', '{', '}'
        );

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            Character closeParenthesis = closeParenthesisMap.get(current);

            if (closeParenthesis == null) {
                continue;
            }

            int openCount = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (closeParenthesis == s.charAt(j) && openCount == 0) {
                    parenthesisCount++;
                    break;
                }

                if (isOpen(s.charAt(j))) {
                    openCount++;
                } else {
                    openCount--;
                }
            }
        }

        return parenthesisCount == s.length()/2;
    }

    public static boolean isOpen(Character ch) {
        return switch (ch) {
            case '(', '[', '{' -> true;
            default -> false;
        };
    }

    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (isOpen(ch)) {
                charStack.push(ch);
            }
            else  {
                if (charStack.isEmpty()) {
                    return false;
                }
                if (charStack.peek() == '(' && ch == ')' || charStack.peek() == '{' && ch == '}' || charStack.peek() == '[' && ch == ']') {
                    charStack.pop();
                }
                else  {
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}{}"));
    }
}
