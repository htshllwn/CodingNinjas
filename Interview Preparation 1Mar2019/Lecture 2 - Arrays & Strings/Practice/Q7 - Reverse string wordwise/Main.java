
// Reverse the given string word wise. That is, the last word in given string should come at 1st place, last second word at 2nd place and so on. Individual words should remain as it is.
// Sample Input:
// Welcome to Coding Ninjas
// Sample Output:
// Ninjas Coding to Welcome

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String s = reader.readLine();

        System.out.println(s);
        System.out.println(reverseWordWise(s));
    }

    public static String reverseWordWise(String input) {
        String[] arr = input.split("\\s");
        String[] revArr = reverseArray(arr);
        String result = String.join(" ", revArr);
        return result;
    }

    public static String[] reverseArray(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr.length - 1 - i] = arr[i];
        }
        return result;
    }
}
