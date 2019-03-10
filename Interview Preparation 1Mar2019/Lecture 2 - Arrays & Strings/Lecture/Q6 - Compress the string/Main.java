
// Write a program to do basic string compression. 
// For a character which is consecutively repeated more than once, 
// replace consecutive duplicate occurrences with the count of repetitions.
// For e.g. if a String has 'x' repeated 5 times, replace this "xxxxx" with "x5".
// Note : Consecutive count of every character in input string is less than equal to 9.
// Input Format :
// Input string S
// Output Format :
// Compressed string 
// Sample Input:
// aaabbccdsa
// Sample Output:
// a3b2c2dsa

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String str = reader.readLine();
        System.out.println(compress(str));
    }

    public static String compress(String inputString) {
        inputString += '\0';
        String result = "";
        char prev = '\0';
        int count = 1;
        for (int i = 0; i < inputString.length(); i++) {
            if (prev != '\0') {
                if (prev == inputString.charAt(i)) {
                    count++;
                } else {
                    result += inputString.charAt(i - 1);
                    result += count > 1 ? count : "";
                    count = 1;
                }
            }
            prev = inputString.charAt(i);
        }
        return result;
    }
}
