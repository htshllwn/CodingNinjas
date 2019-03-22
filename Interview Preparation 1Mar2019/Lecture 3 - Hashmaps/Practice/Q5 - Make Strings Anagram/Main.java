
// Given two strings S1 and S2, find and return the minimum number of deletions to be made (total count of deletions in both strings) in order to make the strings anagram.
// Anagram of a string is a string which is its permutation.
// For example "bbaa" and "abab" are anagrams of each other but "bbaa" and "aaab" are not.
// Input Format :
// Line 1 : String1
// Line 2 : String2
// Output Format :
// Number of deletions required
// Contraints :
// 1<= Length of string <=10^4
// Sample Input 1 :
// cde 
// abc
// Sample Output 1 :
// 4
// Sample Input 2 :
// aab
// aba
// Sample Output 2 :
// 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        System.out.println(makeAnagram(s1, s2));
    }

    public static int makeAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = genMap(s1);
        HashMap<Character, Integer> map2 = genMap(s2);
        int result = 0;

        for (char v : map1.keySet()) {
            if (map2.containsKey(v)) {
                int diff = Math.abs(map1.get(v) - map2.get(v));
                result += diff;
            } else {
                result += map1.get(v);
            }
        }

        for (char v : map2.keySet()) {
            if (map1.containsKey(v)) {
            } else {
                result += map2.get(v);
            }
        }
        return result;
    }

    public static HashMap<Character, Integer> genMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int t = map.get(c);
                map.put(c, t + 1);
            } else {
                map.put(c, 1);
            }
        }

        return map;
    }

}
