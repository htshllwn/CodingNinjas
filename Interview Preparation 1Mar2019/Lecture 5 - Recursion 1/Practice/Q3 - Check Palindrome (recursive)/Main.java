// Check if a given String S is palindrome or not (using recursion). Return true or false.
// Input Format :
// String S
// Output Format :
// true or false
// Sample Input 1 :
// racecar
// Sample Output 1:
// true
// Sample Input 2 :
// ninja
// Sample Output 2:
// false

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String s = reader.readLine();
        System.out.println(isStringPalindrome(s));
    }

    public static boolean isStringPalindrome(String input) {
        if (input.length() <= 1)
            return true;
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isStringPalindrome(input.substring(1, input.length() - 1));
        } else
            return false;
    }
}
