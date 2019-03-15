
// Given a string S, count and return the number of substrings of S that are palindrome.
// Single length substrings are also palindromes. You just need to calculate the count, not the substrings.
// Input Format :
// String S
// Output Format :
// count of palindrome substrings
// Constraints :
// 1 <= Length of S <= 1000
// Sample Input :
// aba
// Sample Output :
// 4
// **Note : Here 4 corresponds to ("a","b","a","aba").

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String str = reader.readLine();
        System.out.println(countPalindromeSubstrings(str));
    }

    public static int countPalindromeSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i == 1) {
                    count++;
                } else {
                    if (isPalindrome(s, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String s, int x, int y) {
        int n = y - x;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(x++) != s.charAt(--y)) {
                return false;
            }
        }
        return true;
    }
}
