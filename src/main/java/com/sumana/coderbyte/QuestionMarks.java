package com.sumana.coderbyte;

public class QuestionMarks {
    public static String QuestionsMarks(String str) {
        str = str.replaceAll("[a-z]", "");
        String result = "false";

        char[] chars = str.toCharArray();
        int lastIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                if (lastIdx != -1) {
                    if ((chars[lastIdx] - '0') + (chars[i] - '0') == 10) {
                        if (i - (lastIdx + 1) == 3) {
                            result = "true";
                        } else  {
                            return "false";
                        }
                    }
                }
                lastIdx = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(QuestionMarks.QuestionsMarks("acc?7??sss?3rr1??????5"));
    }
}
