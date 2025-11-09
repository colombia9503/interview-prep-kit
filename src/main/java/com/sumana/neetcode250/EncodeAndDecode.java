package com.sumana.neetcode250;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
    public static void main(String[] args) {
        var stringsToEncode = new ArrayList<String>();
        stringsToEncode.add("hello");
        stringsToEncode.add("world");
        stringsToEncode.add("john");
        stringsToEncode.add("doe");
        stringsToEncode.add("jane");
        stringsToEncode.add("doe");

        var encodedString = encode(stringsToEncode);
        System.out.println(encode(stringsToEncode));

        System.out.println(decode(encodedString));
    }

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                char c = replaceChar(str.charAt(i), 5, false);
                encodedString.append(c);
            }
            encodedString.append(replaceChar('|', 5, false));
        }

        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        for (char ch : str.toCharArray()) {
            char currCh = replaceChar(ch, 5, true);
            if (currCh != '|') {
                current.append(currCh);
            } else {
                decodedStrings.add(current.toString());
                current = new StringBuilder();
            }
        }

        return decodedStrings;
    }

    private static char replaceChar(char c, int offset, boolean isEncrypted) {
        var currentChar = isEncrypted ? c - offset : c + offset;

        return (char) currentChar;
    }
}
