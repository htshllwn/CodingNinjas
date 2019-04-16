// Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :
// 1. Delete a character

// 2. Replace a character with another one

// 3. Insert a character
// Note - Strings don't contain spaces
// Input Format :
// Line 1 : String s
// Line 2 : String t
// Output Format :
// Line 1 : Edit Distance value
// Constraints
// 1<= m,n <= 20
// Sample Input 1 :
// abc
// dc
// Sample Output 1 :
// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        System.out.println(editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2) {
        // Recursive
        // int resREC = editDistanceREC(s1, s2);
        // return resREC;

        // Memoization
        HashMap<String, Integer> map = new HashMap<>();
        int resMEM = editDistanceMEM(s1, s2, map);
        // System.out.println(map);
        return resMEM;
    }

    public static int editDistanceREC(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        if (size1 == 0 || size2 == 0) {
            return size1 != 0 ? size1 : size2;
        }
        int res = 0;
        ArrayList<Integer> resList = new ArrayList<>();
        if (s1.charAt(0) == s2.charAt(0)) {
            resList.add(editDistanceREC(s1.substring(1), s2.substring(1)));
        }
        resList.add(1 + editDistanceREC(s1.substring(1), s2.substring(1)));
        resList.add(1 + editDistanceREC(s1, s2.substring(1)));
        resList.add(1 + editDistanceREC(s1.substring(1), s2));

        res = Collections.min(resList);

        // System.out.println(s1 + ", " + s2 + ", " + res);
        // System.out.println(resList);
        return res;
    }

    public static int editDistanceMEM(String s1, String s2, HashMap<String, Integer> map) {
        int size1 = s1.length();
        int size2 = s2.length();
        if (size1 == 0 || size2 == 0) {
            return size1 != 0 ? size1 : size2;
        }
        String str = s1 + "," + s2;
        if (map.containsKey(str))
            return map.get(str);
        int res = 0;
        ArrayList<Integer> resList = new ArrayList<>();
        if (s1.charAt(0) == s2.charAt(0)) {
            resList.add(editDistanceMEM(s1.substring(1), s2.substring(1), map));
        }
        resList.add(1 + editDistanceMEM(s1.substring(1), s2.substring(1), map));
        resList.add(1 + editDistanceMEM(s1, s2.substring(1), map));
        resList.add(1 + editDistanceMEM(s1.substring(1), s2, map));

        res = Collections.min(resList);

        // System.out.println(s1 + ", " + s2 + ", " + res);
        // System.out.println(resList);
        map.put(str, res);
        return res;
    }

}
