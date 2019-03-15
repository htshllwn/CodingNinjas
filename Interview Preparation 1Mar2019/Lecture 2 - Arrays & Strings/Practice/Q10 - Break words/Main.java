// You are given a sentence contained in given string S. Write a function which will replace all the words within the sentence whose length is even and greater than equal to 4, with a space between the two equal halves of the word.
// Space complexity should be O(1).
// Input Format :
// String S
// Output Format :
// Updated string
// Constraints :
// 1 <= Length of S <= 10000
// Sample Input :
// Helloo world good morniing
// Sample Output :
// Hel loo world go od morn iing

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String str = reader.readLine();
        System.out.println(breakWords(str));
    }

    public static String breakWords(String input){
        input = input.trim() + " ";
        String result = "";
        int n = input.length();
        int prevIndex = 0;
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == ' ') {
                int len = i - prevIndex;
                if (len % 2 == 0 && len >= 4) {
                    int mid = (len / 2);
                    result += input.substring(prevIndex, prevIndex + mid) + " " + input.substring(prevIndex + mid, i) + " ";
                } else {
                    result += input.substring(prevIndex, i) + " ";
                }
                prevIndex = i + 1;
            }
        }
        return result.trim();
	}
}
