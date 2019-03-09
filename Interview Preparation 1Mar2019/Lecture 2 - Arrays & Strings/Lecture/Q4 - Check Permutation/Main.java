
// Given two strings, 
// check if they are permutations of each other. 
// Return true or false.
// Permutation means - 
// length of both the strings should same 
// and should contain same set of characters. 
// Order of characters doesn't matter.
// Note : Input strings contain only lowercase english alphabets.
// Input format :
// Line 1 : String 1
// Line 2 : String 2
// Sample Input 1 :
// abcde
// baedc
// Sample Output 1 :
// true
// Sample Input 2 :
// abc
// cbd
// Sample Output 2 :
// false

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String string1 = reader.readLine();
        String string2 = reader.readLine();

        System.out.println(isPermutation(string1, string2));
    }

    public static boolean isPermutation(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        int[] counts1 = countsArray(input1);
        int[] counts2 = countsArray(input2);
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] != counts2[i])
                return false;
        }
        return true;
    }

    public static int[] countsArray(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }
        return counts;
    }
}
