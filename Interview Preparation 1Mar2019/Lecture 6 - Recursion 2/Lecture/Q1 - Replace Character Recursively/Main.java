// Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
// Do this recursively.
// Input Format :
// Line 1 : Input String S
// Line 2 : Character c1 and c2 (separated by space)
// Output Format :
// Updated string
// Constraints :
// 1 <= Length of String S <= 10^6
// Sample Input :
// abacd
// a x
// Sample Output :
// xbxcd

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String input = reader.readLine();
        String[] arr = reader.readLine().split("\\s");


        System.out.println(replaceCharacter(input, arr[0].charAt(0), arr[1].charAt(0)));
    }

    public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 0)
            return "";
        char newChar = input.charAt(0);
        if (newChar == c1) {
            newChar = c2;
        }
        return newChar + replaceCharacter(input.substring(1, input.length()), c1, c2);
    }
}
