
// Given a string S, find the largest substring with no repetition i.e. largest substring which contain all unique characters.
// Input Format :
// String S
// Output Format :
// Largest unique substring
// Constraints :
// 1 <= Length os String S <= 10^3
// Sample Input:
// abcdabceb
// Sample Output:
// dabce

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String str = reader.readLine();
        System.out.println(findLargestUniqueSubstring(str));
    }

    public static String findLargestUniqueSubstring(String str) {
        String result = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String temp = str.substring(i, j);
                if (temp.length() > result.length()) {
                    if (checkUnique(temp)) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    public static boolean checkUnique(String s) {
        String[] strArr = s.split("");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String e : strArr) {
            if (map.containsKey(e)) {
                return false;
            } else {
                map.put(e, 1);
            }
        }
        return true;
    }
}
