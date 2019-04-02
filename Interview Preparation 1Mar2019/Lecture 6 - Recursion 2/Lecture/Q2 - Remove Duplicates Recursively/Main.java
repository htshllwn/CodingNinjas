
// Given a string S, remove consecutive duplicates from it recursively.
// Input Format :
// String S
// Output Format :
// Output string
// Constraints :
// 1 <= Length of String S <= 10^3
// Sample Input :
// aabccba
// Sample Output :
// abcba

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String input = reader.readLine();

        System.out.println(removeConsecutiveDuplicates(input));
    }

    public static String removeConsecutiveDuplicates(String s) {
        char c1 = s.charAt(0);
        int start = s.length();
        for (int i = 1; i < s.length(); i++) {
            char c2 = s.charAt(i);
            if (c1 != c2) {
                start = i;
                break;
            }
        }
        if (start == s.length()) {
            return c1 + "";
        }
        return c1 + removeConsecutiveDuplicates(s.substring(start, s.length()));
    }
}
