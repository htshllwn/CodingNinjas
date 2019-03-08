
// Given a string S, 
// reverse each word of a string individually. 
// For eg. if a string is "abc def", 
// reversed string should be "cba fed".
// Input Format :
// String S
// Output Format :
// Updated string
// Constraints :
// 1 <= Length of S <= 1000
// Sample Input :
// Welcome to Coding Ninjas
// Sample Output:
// emocleW ot gnidoC sajniN

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String str = reader.readLine();
        System.out.println(reverseEachWord(str));
    }

    public static String reverseEachWord(String input) {
        String result = "";
        String[] strArr = input.split("\\s");
        for (String s : strArr) {
            result += reverseString(s) + " ";
        }
        return result;
    }

    public static String reverseString(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(str.length() - i - 1);
        }
        return new String(result);
    }
}
